package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.dto.DeckDto;
import pl.valdemar.flashcardsboot.event.UserRegistrationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.service.DeckService;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.AttributeNames;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class DeckController {

    // == fields ==
    private final DeckService deckService;
    private final UserService userService;

    // == constructors ==
    @Autowired
    public DeckController(DeckService deckService, UserService userService) {
        this.deckService = deckService;
        this.userService = userService;
    }

    // == handler methods ==
    @GetMapping(Mappings.HOME)
    public String index() {
        return "redirect:" + Mappings.INDEX;
    }

    @GetMapping(Mappings.INDEX)
    public String index(Model model, Principal principal) {
        List<Deck> deckList = (List<Deck>) deckService.findDecksByUserId(getUserId(principal));
        model.addAttribute(AttributeNames.DECKS, deckList.isEmpty() ? Collections.EMPTY_LIST : deckList);
        return ViewNames.INDEX;
    }

    @GetMapping(Mappings.ADD_DECK)
    public String create(Model model) {
        model.addAttribute("deck", new DeckDto());
        log.info("model: {}", model);
        return ViewNames.ADD_DECK;
    }

    @PostMapping(Mappings.ADD_DECK)
    public String create(@Valid @ModelAttribute("deck") DeckDto deckDto, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return ViewNames.ADD_DECK;
        }
        Long userId = getUserId(principal);
        if (deckService.findDeckByDeckName(deckDto.getDeckName(), userId).isPresent()) {
            return "redirect:" + Mappings.ADD_DECK + "?already_exist";
        }
        deckService.createDeck(deckDto, userId);
        return "redirect:" + Mappings.INDEX;
    }

    @GetMapping(Mappings.UPDATE_DECK)
    public String showUpdateCourseForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("deck", deckService.findDeckById(id).get());
        return "update-deck";
    }

    @PutMapping(Mappings.UPDATE_DECK)
    public String updateCourse(@PathVariable("id") Long id, @Valid Deck deck, BindingResult result,
                               Model model, Principal principal) {
        if (result.hasErrors()) {
            deck.setId(id);
            return ViewNames.UPDATE_DECK;
        }
        deck.setUserId(2);
        log.info(deck.toString());
        deckService.updateDeck(deck);
        model.addAttribute("decks", deckService.findDecksByUserId(getUserId(principal)));
        return "redirect:" + Mappings.INDEX;
    }

    @DeleteMapping(Mappings.DELETE_DECK)
    public String deleteCourse(@PathVariable("id") Long id, Model model, Principal principa) {
        deckService.deleteDeckById(id);
        model.addAttribute("courses", deckService.findDecksByUserId(getUserId(principa)));
        return "redirect:" + Mappings.INDEX;
    }

    private Long getUserId(Principal principal) {
        return userService.findByUsername(principal.getName()).getId();
    }
}
