package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.valdemar.flashcardsboot.model.Deck;

import java.util.Optional;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {

    Optional<Deck> findByDeckName(String deckName);

    Iterable<Deck> findDecksByUserId(Long userId);
}
