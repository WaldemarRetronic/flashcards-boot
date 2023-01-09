package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.model.MessageGenerator;
import pl.valdemar.flashcardsboot.service.FlashcardService;
import pl.valdemar.flashcardsboot.service.StudyService;
import pl.valdemar.flashcardsboot.service.UserService;
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
/**
 * MessageGenerator, StudyService have session scope.
 * Crucially, the controller in this approach MUST be request scoped. The default is for Spring to create a global
 * singleton instance of the controller, and this would not work as a singleton is shared by all requests (you can’t
 * inject session scoped objects into singleton scoped objects anyway).
 */
@Scope("request")
public class StudyControl {

    // == fields ==
    @Autowired
    private StudyService studyService;

    private final FlashcardService flashcardService;
    private final JSONObject json;
    private final MessageGenerator messageGenerator;
    private final UserService userService;

    // == constructors ==
    public StudyControl(FlashcardService flashcardService, JSONObject json, MessageGenerator messageGenerator, UserService userService) {
        this.flashcardService = flashcardService;
        this.json = json;
        this.messageGenerator = messageGenerator;
        this.userService = userService;
    }

    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("index", Mappings.INDEX);
        paths.put("add-deck", Mappings.ADD_DECK);
        paths.put("logout", Mappings.LOGOUT);
        return paths;
    }

    // == handler methods ==
    @GetMapping(Mappings.STUDY_SESSION)
    public String flashcard(@RequestParam long id, Model model, Principal principal) {
        log.info("flashcard method called from Study controller");
        log.info("flashcards from database = {}", flashcardService.findFlashcards(getUserId(principal), id).toString());
        studyService.setFlashcards((List<Flashcard>) flashcardService.findFlashcards(getUserId(principal), id));
        List<Flashcard> flashcards = studyService.getFlashcards();
        log.info("flashcards from StudyService = {}", flashcards.toString());
        if (flashcards.isEmpty()) {
            log.info("flashcards is empty");
            model.addAttribute("mainMessage", messageGenerator.getEmptyDeckMessage());
            return ViewNames.RESULT_STUDY;
        }
        model.addAttribute("startMessage", messageGenerator.getStartMessage());
        return ViewNames.STUDY_SESSION;
    }

    @ResponseBody
    @PostMapping(Mappings.STUDY)
    public String getFlashcard(@RequestBody Map<String, String> resultMap) {
        log.info("getFlashcard method called");
        log.info("correct = {}", resultMap.get("correct"));
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
            log.info("frontSide = {}", frontSide);
            log.info("backSide = {}", backSide);
        } else {
            json.put("finished", "true");
        }
        return json.toString();
    }

    @GetMapping(Mappings.RESULT_STUDY)
    public String result(Model model) {
        model.addAttribute("mainMessage", messageGenerator.getMainMessage());
        model.addAttribute("resultMessage", messageGenerator.getResultMessage());
        studyService.reset();
        log.info("result method called");
        return ViewNames.RESULT_STUDY;
    }

    private Long getUserId(Principal principal) {
        return userService.findByUsername(principal.getName()).getId();
    }

    @PostConstruct
    public void init() {
        log.info("StudyControl created");
    }

    @PreDestroy
    public void shutdown() {
        log.info("StudyControl to be deleted");
    }

}
