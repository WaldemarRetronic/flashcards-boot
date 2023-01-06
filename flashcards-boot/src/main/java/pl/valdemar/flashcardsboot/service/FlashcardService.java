package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.dto.FlashcardDto;
import pl.valdemar.flashcardsboot.model.Flashcard;

public interface FlashcardService {

    Flashcard createFlashcard(FlashcardDto flashcardDto, Long userId, Long deckId);

    Iterable<Flashcard> findFlashcards(Long userId, Long deckId);

    Iterable<Flashcard> findAllFlashcards(Long userId);

    Flashcard updateFlashcard(Flashcard flashCard);

    void deleteFlashcardById(Long id);
}
