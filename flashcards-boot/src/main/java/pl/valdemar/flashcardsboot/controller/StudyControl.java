package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.model.MessageGenerator;
import pl.valdemar.flashcardsboot.service.DeckService;
import pl.valdemar.flashcardsboot.service.FlashcardService;
import pl.valdemar.flashcardsboot.service.StudyService;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.AttributeNames;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@Scope("request")
public class StudyControl {

    // == fields ==
    @Autowired
    private StudyService studyService;
    private final FlashcardService flashcardService;
    private final JSONObject json;
    private final MessageGenerator messageGenerator;
    private final UserService userService;
    private final DeckService deckService;

    // == constructors ==
    public StudyControl(FlashcardService flashcardService, JSONObject json, MessageGenerator messageGenerator,
                        UserService userService, DeckService deckService) {
        this.flashcardService = flashcardService;
        this.json = json;
        this.messageGenerator = messageGenerator;
        this.userService = userService;
        this.deckService = deckService;
    }

    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("index", Mappings.INDEX);
        paths.put("logout", Mappings.LOGOUT);
        paths.put("account", Mappings.ACCOUNT_SETTINGS);
        paths.put("shared", Mappings.SHARED);
        paths.put("search", Mappings.SEARCH);
        return paths;
    }

    // == handler methods ==
    @GetMapping(Mappings.STUDY_SESSION)
    public String flashcard(@RequestParam long id, Model model) {
        Deck deck = deckService.findDeckById(id).get();
        Long userIdOfSharedDeck = deck.getUserId();
        String deckName = deckService.findDeckById(id).get().getDeckName();
        model.addAttribute(AttributeNames.DECK_NAME, deckName);
        studyService.setFlashcards((List<Flashcard>) flashcardService.findFlashcards(userIdOfSharedDeck, id));
        List<Flashcard> flashcards = studyService.getFlashcards();
        if (flashcards.isEmpty()) {
            model.addAttribute(AttributeNames.MAIN_MESSAGE, messageGenerator.getEmptyDeckMessage());
            return ViewNames.STUDY_RESULT;
        }
        model.addAttribute(AttributeNames.START_MESSAGE, messageGenerator.getStartMessage());
        model.addAttribute((AttributeNames.STUDY_NO_OF_FC), flashcards.size());
        return ViewNames.STUDY_SESSION;
    }

    @ResponseBody
    @PostMapping(Mappings.STUDY)
    public String getFlashcard(@RequestBody Map<String, String> resultMap) {
        if (!resultMap.get("correct").equals("start")) {
            studyService.update(resultMap.get("correct"));
        }
        Flashcard flashcard = studyService.getNextFlashcard();
        if (flashcard != null) {
            String frontSide = flashcard.getForeignName();
            String backSide = flashcard.getNativeName();
            String variety = flashcard.getVariety();
            json.put("frontSide", frontSide);
            json.put("backSide", backSide);
            json.put("finished", "false");
            json.put("variety", variety);
        } else {
            json.put("finished", "true");
        }
        return json.toString();
    }

    @GetMapping(Mappings.STUDY_RESULT)
    public String result(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, messageGenerator.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, messageGenerator.getResultMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, messageGenerator.getResultMessage());
        studyService.reset();
        return ViewNames.STUDY_RESULT;
    }

}
