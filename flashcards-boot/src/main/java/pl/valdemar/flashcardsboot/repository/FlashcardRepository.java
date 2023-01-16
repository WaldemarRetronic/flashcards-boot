package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.valdemar.flashcardsboot.model.Flashcard;

@Repository
public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {

    Iterable<Flashcard> findByUserIdAndDeckId(Long userId, Long deckId);

    Iterable<Flashcard> findByUserId(Long userId);

}
