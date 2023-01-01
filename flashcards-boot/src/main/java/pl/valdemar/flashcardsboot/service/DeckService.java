package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.model.Deck;

import java.util.Optional;

public interface DeckService {

    Deck createDeck(Deck deck);

    Optional<Deck> findCourseById(Long deckId);

    Iterable<Deck> findAllDecks();

    Deck updateDeck(Deck deck);

    void deleteDeckById(Long deckId);

}
