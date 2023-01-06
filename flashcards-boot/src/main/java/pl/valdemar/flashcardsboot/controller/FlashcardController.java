package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.dto.FlashcardDto;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.service.DeckService;
import pl.valdemar.flashcardsboot.service.FlashcardService;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.AttributeNames;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class FlashcardController {

    // == fields ==
    private final FlashcardService flashCardService;
    private final DeckService deckService;
    private final UserService userService;

    // == constructors ==
    @Autowired
    public FlashcardController(FlashcardService flashCardService, DeckService deckService, UserService userService) {
        this.flashCardService = flashCardService;
        this.deckService = deckService;
        this.userService = userService;
    }

    // == model attributes ==
//    @ModelAttribute(name = AttributeNames.DECKS)
//    public List<Deck> deckList(Principal principal) {
//        return (List<Deck>) deckService.findDecksByUserId(getUserId(principal));
//    }
    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("update", Mappings.UPDATE_FLASHCARD);
        paths.put("delete", Mappings.DELETE_FLASHCARD);
        paths.put("index", Mappings.INDEX);
        paths.put("logout", Mappings.LOGOUT);
        paths.put("add-deck", Mappings.ADD_DECK);
        paths.put("add-flashcard", Mappings.ADD_FLASHCARD);
        return paths;
    }

    // == handler methods ==
    @GetMapping(Mappings.SHOW_FLASHCARDS)
    public String listFlashcards(@RequestParam Long id, Principal principal, Model model) {
        List<Flashcard> flashCards = (List<Flashcard>) flashCardService.findFlashcards(getUserId(principal), id);
        model.addAttribute(AttributeNames.FLASHCARDS, flashCards.isEmpty() ? Collections.EMPTY_LIST : flashCards);
        model.addAttribute(AttributeNames.DECK_ID, id);
        return ViewNames.FLASHCARDS;
    }

    @GetMapping(Mappings.ADD_FLASHCARD)
    public String create(@RequestParam Long deckId, Model model) {
        model.addAttribute(AttributeNames.FLASHCARD, new FlashcardDto(deckId));
        log.info("model: {}", model);
        return ViewNames.ADD_FLASHCARD;
    }

    @PostMapping(Mappings.ADD_FLASHCARD)
    public String create(@Valid @ModelAttribute("flashcard") FlashcardDto flashcardDto,
                         @RequestParam Long deckId, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return ViewNames.ADD_FLASHCARD;
        }
        Long userId = getUserId(principal);
        flashCardService.createFlashcard(flashcardDto, userId, deckId);
        return "redirect:" + Mappings.SHOW_FLASHCARDS + "?id=" + deckId;
    }
//
//    @GetMapping(Mappings.UPDATE_DECK)
//    public String showUpdateCourseForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute(AttributeNames.DECK, deckService.findDeckById(id).get());
//        return "update-deck";
//    }
//
//    @PutMapping(Mappings.UPDATE_DECK)
//    public String updateDeck(@PathVariable("id") Long id, @Valid Deck deck, BindingResult result,
//                             Model model, Principal principal) {
//        if (result.hasErrors()) {
//            deck.setId(id);
//            return ViewNames.UPDATE_DECK;
//        }
//        deck.setUserId(getUserId(principal));
//        log.info(deck.toString());
//        deckService.updateDeck(deck);
//        return "redirect:" + Mappings.INDEX;
//    }
//
//    @DeleteMapping(Mappings.DELETE_DECK)
//    public String deleteCourse(@PathVariable("id") Long id) {
//        deckService.deleteDeckById(id);
//        return "redirect:" + Mappings.INDEX;
//    }

//
//    @GetMapping(Mappings.ADD_FLASHCARD)
//    public String createFlashcard(Model model) {
//        model.addAttribute("addFlashcardForm", new AddFlashcardForm());
//        return ViewNames.ADD_FLASHCARD;
//    }
//
//    @PostMapping(Mappings.ADD_FLASHCARD)
//    public String createFlashcard(@ModelAttribute(AttributeNames.ADD_FLASHCARD_FORM) AddFlashcardForm addFlashcardForm,
//                                  Model model, Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        Flashcard flashCard = new Flashcard(addFlashcardForm.getNativeName(), addFlashcardForm.getForeignName(),
//                user.getId(), Integer.parseInt(addFlashcardForm.getDeckId()), addFlashcardForm.getVariety());
//        flashCardService.save(flashCard);
//        return "redirect:" + Mappings.ADD_FLASHCARD;
//    }
//
//    @GetMapping(Mappings.DELETE_FC)
//    public String delete(@RequestParam int id, @RequestParam int deckId) {
//        log.info("Deleting flashcard with id={}", id);
//        flashCardService.deleteFC(id);
//        return "redirect:" + Mappings.FLASHCARDS + "/?deckId=" + deckId;
//    }
//
//    @GetMapping(Mappings.SEARCH)
//    public String search() {
//        return ViewNames.SEARCH;
//    }
//
//    @PostMapping(Mappings.SEARCH)
//    public String search(@RequestParam String keyword, Authentication authentication, Model model) {
//        log.info("search called with keyword: {}", keyword);
//        User user = (User) authentication.getPrincipal();
//        List<Flashcard> foundFlashcards =
//                flashCardService.findAll(user.getId())
//                        .stream()
//                        .filter(flashCard -> flashCard.getForeignName().equals(keyword) || flashCard.getNativeName().equals(keyword))
//                        .map(flashCard -> {
//                            flashCard.setDeckName(deckService.getDeck(flashCard.getDeckId()).getDeckName());
//                            return flashCard;
//                        })
//                                .collect(Collectors.toList());
//        log.info("foundFlashcards: {}", foundFlashcards.size());
//        model.addAttribute("foundFlashcards", foundFlashcards);
//        return ViewNames.SEARCH;
//    }


    private Long getUserId(Principal principal) {
        return userService.findByUsername(principal.getName()).getId();
    }
}
