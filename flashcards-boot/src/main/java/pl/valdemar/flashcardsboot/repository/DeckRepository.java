package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.valdemar.flashcardsboot.model.Deck;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
}
