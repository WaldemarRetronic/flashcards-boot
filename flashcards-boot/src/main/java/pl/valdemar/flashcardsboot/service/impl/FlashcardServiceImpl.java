package pl.valdemar.flashcardsboot.service.impl;

import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.model.FlashCard;
import pl.valdemar.flashcardsboot.repository.FlashcardRepository;
import pl.valdemar.flashcardsboot.service.FlashcardService;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    private FlashcardRepository flashcardRepository;


    @Override
    public FlashCard createFlashcard(FlashCard flashCard) {
        return null;
    }

    @Override
    public Iterable<FlashCard> findByUserDeckId(Long userId, Long deckId) {
        return null;
    }

    @Override
    public Iterable<FlashCard> findAllFlashcards(Long userId) {
        return null;
    }

    @Override
    public FlashCard updateFlashcard(FlashCard flashCard) {
        return null;
    }

    @Override
    public void deleteFlashcardById(Long id) {

    }
}
