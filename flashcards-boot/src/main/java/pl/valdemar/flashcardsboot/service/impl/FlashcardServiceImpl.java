package pl.valdemar.flashcardsboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.dto.FlashcardDto;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.repository.FlashcardRepository;
import pl.valdemar.flashcardsboot.service.FlashcardService;

import java.util.Optional;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    private FlashcardRepository flashcardRepository;

    @Autowired
    public FlashcardServiceImpl(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public Flashcard createFlashcard(FlashcardDto flashcardDto, Long userId, Long deckId) {
        Flashcard flashcard = new Flashcard();
        flashcard.setNativeName(flashcardDto.getNativeName());
        flashcard.setForeignName(flashcardDto.getForeignName());
        flashcard.setVariety(flashcardDto.getVariety());
        flashcard.setUserId(userId);
        flashcard.setDeckId(deckId);
        return flashcardRepository.save(flashcard);
    }

    @Override
    public Iterable<Flashcard> findFlashcards(Long userId, Long deckId) {
        return flashcardRepository.findByUserIdAndDeckId(userId, deckId);
    }

    @Override
    public Optional<Flashcard> findFlashcardById(Long id) {
        return flashcardRepository.findById(id);
    }

    @Override
    public Flashcard updateFlashcard(Flashcard flashCard) {
        return flashcardRepository.save(flashCard);
    }

    @Override
    public void deleteFlashcardById(Long id) {
        flashcardRepository.deleteById(id);
    }
}
