package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());
        List<Deck> deckList = (List<Deck>) deckService.findDecksByUserId(applicationUser.getId());
        model.addAttribute(AttributeNames.DECKS, deckList.isEmpty() ? Collections.EMPTY_LIST : deckList);
        return ViewNames.INDEX;
    }

//    @GetMapping(Mappings.ADD_DECK)
//    public String createDeck(@RequestParam(required = false, defaultValue = "-1") long id, Model model) {
//        Deck deck = deckService.findDeckById(id).orElseGet(() -> new Deck("", ""));
//        model.addAttribute("deck", deck);
//        return ViewNames.ADD_DECK;
//    }

    @GetMapping(Mappings.ADD_DECK)
    public String create(Model model) {
        model.addAttribute("deck", new DeckDto());
        log.info("model: {}", model);
        return "add-deck";
    }

    @PostMapping(Mappings.ADD_DECK)
    public String create(@Valid @ModelAttribute("deck") DeckDto deckDto, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return ViewNames.ADD_DECK;
        }
        if (deckService.findDeckByDeckName(deckDto.getDeckName()).isPresent()) {
            return "redirect:" + Mappings.ADD_DECK + "?already_exist";
        }
        deckService.createDeck(deckDto, userService.findByUsername(principal.getName()).getId());
        return "redirect:" + Mappings.INDEX;
    }
}
