package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.repository.DeckRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CrudRepositoryTests {

    @Autowired
    private DeckRepository deckRepository;

    // Test case creates a new deck and saves it into the database. We then find the deck by its ID and
    // assert that it is the same course we’ve created.
    @Test
    public void givenCreateDeckWhenLoadTheDeckThenExpectSameDeck() {
        Deck deck = new Deck("Norwegian Level A1-04", "Familiar everyday expressions and very basic phrases", 1);
        Deck savedDeck = deckRepository.save(deck);
        assertThat(deckRepository.findById(savedDeck.getId()).get()).isEqualTo(deck);
    }

    // Test case creates and deletes a deck. It asserts whether the deck deletion is successful.
    @Test
    public void givenDeleteDeckWhenLoadTheDeckThenExpectNoDeck() {
        Deck deck = new Deck("Norwegian Level A1-04", "Familiar everyday expressions and very basic phrases", 1);
        Deck savedDeck = deckRepository.save(deck);
        assertThat(deckRepository.findById(savedDeck.getId()).get()).isEqualTo(deck);
        deckRepository.delete(deck);
        assertThat(deckRepository.findById(savedDeck.getId()).isPresent()).isFalse();
    }

}
