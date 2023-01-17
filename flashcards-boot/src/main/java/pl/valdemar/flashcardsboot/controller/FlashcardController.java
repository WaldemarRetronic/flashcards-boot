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
import java.util.stream.Collectors;

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
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("update", Mappings.UPDATE_FLASHCARD);
        paths.put("delete", Mappings.DELETE_FLASHCARD);
        paths.put("index", Mappings.INDEX);
        paths.put("logout", Mappings.LOGOUT);
        paths.put("add-flashcard", Mappings.ADD_FLASHCARD);
        paths.put("show-flashcards", Mappings.SHOW_FLASHCARDS);
        paths.put("search", Mappings.SEARCH);
        paths.put("add-deck", Mappings.ADD_DECK);
        paths.put("account", Mappings.ACCOUNT_SETTINGS);
        paths.put("shared", Mappings.SHARED);
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

    @GetMapping(Mappings.FC_SHARED)
    public String listSharedFlashcards(@RequestParam Long id, Model model, Principal principal) {
        Deck deck = deckService.findDeckById(id).get();
        Long userIdOfSharedDeck = deck.getUserId();
        if (!deck.isShared() || (userIdOfSharedDeck == getUserId(principal))) {
            model.addAttribute(AttributeNames.FLASHCARDS, Collections.EMPTY_LIST);
            return ViewNames.FC_SHARED;
        }
        List<Flashcard> flashCards = (List<Flashcard>) flashCardService.findFlashcards(userIdOfSharedDeck, id);
        model.addAttribute(AttributeNames.FLASHCARDS, flashCards.isEmpty() ? Collections.EMPTY_LIST : flashCards);
        model.addAttribute(AttributeNames.DECK_ID, id);
        return ViewNames.FC_SHARED;
    }

    @GetMapping(Mappings.ADD_FLASHCARD)
    public String create(@RequestParam Long deckId, Model model) {
        model.addAttribute(AttributeNames.FLASHCARD_DTO, new FlashcardDto(deckId));
        model.addAttribute(AttributeNames.DECK_ID, deckId);
        log.info("model: {}", model);
        return ViewNames.ADD_FLASHCARD;
    }

    @PostMapping(Mappings.ADD_FLASHCARD)
    public String create(@ModelAttribute(AttributeNames.FLASHCARD_DTO) @Valid FlashcardDto flashcardDto, BindingResult result,
                         @RequestParam Long deckId, Model model, Principal principal) {
        if (result.hasErrors()) {
            flashcardDto.setDeckId(deckId);
            return ViewNames.ADD_FLASHCARD;
        }
        Long userId = getUserId(principal);
        flashCardService.createFlashcard(flashcardDto, userId, deckId);
        return "redirect:" + Mappings.SHOW_FLASHCARDS + "?id=" + deckId;
    }

    @GetMapping(Mappings.UPDATE_FLASHCARD)
    public String showUpdateFlashcardForm(@RequestParam("id") Long id, Model model) {
        Flashcard flashcard = flashCardService.findFlashcardById(id).get();
        model.addAttribute(AttributeNames.FLASHCARD, flashcard);
        model.addAttribute(AttributeNames.DECK_ID, flashcard.getDeckId());
        return ViewNames.UPDATE_FLASHCARD;
    }

    @PutMapping(Mappings.UPDATE_FLASHCARD)
    public String updateFlashcard(@RequestParam("id") Long id, @Valid Flashcard flashcard, BindingResult result,
                                  Model model, Principal principal) {
        if (result.hasErrors()) {
            log.info("update error");
            flashcard.setId(id);
            return ViewNames.UPDATE_FLASHCARD;
        }
        log.info("called updateFlashcard", flashcard.toString());
        flashcard.setUserId(getUserId(principal));
        log.info(flashcard.toString());
        flashCardService.updateFlashcard(flashcard);
        return "redirect:" + Mappings.SHOW_FLASHCARDS + "?id=" + flashcard.getDeckId();
    }

    @DeleteMapping(Mappings.DELETE_FLASHCARD)
    public String deleteFlashcard(@RequestParam("id") Long id, Principal principal){
        log.info("called deleteFlashcard");
        Long deckId = flashCardService.findFlashcardById(id).get().getDeckId();
        flashCardService.deleteFlashcardById(id);
        return "redirect:" + Mappings.SHOW_FLASHCARDS + "?id=" + deckId;
    }

    @GetMapping(Mappings.SEARCH)
    public String search(Model model) {
        model.addAttribute(AttributeNames.FLASHCARDS, Collections.EMPTY_LIST);
        model.addAttribute("hidden", "true");
        return ViewNames.SEARCH;
    }

    @PostMapping(Mappings.SEARCH)
    public String search(@RequestParam String keyword, Principal principal, Model model) {
        log.info("search called with keyword: {}", keyword);
        List<Flashcard> foundFlashcards =
                ((List<Flashcard>) flashCardService.findAll(getUserId(principal)))
                        .stream()
                        .filter(flashCard -> flashCard.getForeignName().contains(keyword) || flashCard.getNativeName().contains(keyword))
                        .map(flashCard -> {
                            flashCard.setDeckName(deckService.findDeckById(flashCard.getDeckId()).get().getDeckName());
                            return flashCard;
                        })
                        .collect(Collectors.toList());
        log.info("foundFlashcards: {}", foundFlashcards.size());
        model.addAttribute("hidden", "false");
        model.addAttribute(AttributeNames.FLASHCARDS, foundFlashcards.isEmpty() ? Collections.EMPTY_LIST : foundFlashcards);
        return ViewNames.SEARCH;
    }


    private Long getUserId(Principal principal) {
        return userService.findByUsername(principal.getName()).getId();
    }
}
