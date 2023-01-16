package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.dto.DeckDto;
import pl.valdemar.flashcardsboot.model.Deck;

import java.util.Optional;

public interface DeckService {

    Deck createDeck(DeckDto deckDto, Long userId);

    Optional<Deck> findDeckById(Long deckId);

    Optional<Deck> findDeckByDeckName(String deckName, Long userId);

    Iterable<Deck> findDecksByUserId(Long userId);

    Deck updateDeck(Deck deck);

    void deleteDeckById(Long deckId);

    void deleteAll(Long userId);

    Iterable<Deck> findDecksByShared(boolean shared, Long userId);
}
