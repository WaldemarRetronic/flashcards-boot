package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.service.DeckService;
import pl.valdemar.flashcardsboot.util.AttributeNames;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class DeckController {

    // == fields ==
    private final DeckService deckService;


    // == constructors ==
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    // == handler methods ==

    @GetMapping(Mappings.HOME)
    public String index() { return "redirect:" + Mappings.INDEX; }

    @GetMapping(Mappings.INDEX)
    public String index(Model model) {
        List<Deck> deckList = (List<Deck>) deckService.findAllDecks();
        model.addAttribute(AttributeNames.DECKS, deckList.isEmpty() ? Collections.EMPTY_LIST : deckList);
        return ViewNames.INDEX;
    }
}
