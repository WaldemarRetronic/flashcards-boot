package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.valdemar.flashcardsboot.model.FlashCard;

@Repository
public interface FlashCardRepository extends CrudRepository<FlashCard, Long> {
}
