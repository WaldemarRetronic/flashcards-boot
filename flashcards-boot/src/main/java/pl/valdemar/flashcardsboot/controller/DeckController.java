package pl.valdemar.flashcardsboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.service.DeckService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class DeckController {

    private final DeckService deckService;


    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/")
    public String index() { return "redirect:/index"; }

    @GetMapping("/index")
    public String index(Model model) {
        List<Deck> deckList = (List<Deck>) deckService.findAllDecks();
        model.addAttribute("decks", deckList.isEmpty() ? Collections.EMPTY_LIST : deckList);
        return "index";
    }
}
