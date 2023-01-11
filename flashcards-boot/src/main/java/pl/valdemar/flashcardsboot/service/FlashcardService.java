package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.dto.FlashcardDto;
import pl.valdemar.flashcardsboot.model.Flashcard;

import java.util.Optional;

public interface FlashcardService {

    Flashcard createFlashcard(FlashcardDto flashcardDto, Long userId, Long deckId);

    Iterable<Flashcard> findFlashcards(Long userId, Long deckId);

    Optional<Flashcard> findFlashcardById(Long id);

    Flashcard updateFlashcard(Flashcard flashCard);

    void deleteFlashcardById(Long id);

    Iterable<Flashcard> findAll(Long userId);

    void deleteAll(Long userId);
}
