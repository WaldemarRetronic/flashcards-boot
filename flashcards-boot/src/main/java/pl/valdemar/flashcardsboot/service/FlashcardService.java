package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.model.FlashCard;

public interface FlashcardService {

    FlashCard createFlashcard(FlashCard flashCard);

    Iterable<FlashCard> findByUserDeckId(Long userId, Long deckId);

    Iterable<FlashCard> findAllFlashcards(Long userId);

    FlashCard updateFlashcard(FlashCard flashCard);

    void deleteFlashcardById(Long id);
}
