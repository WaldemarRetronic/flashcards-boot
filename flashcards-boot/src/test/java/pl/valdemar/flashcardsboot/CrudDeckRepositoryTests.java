package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.repository.DeckRepository;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CrudDeckRepositoryTests {

    @Autowired
    private DeckRepository deckRepository;

    // Test case creates a new deck and saves it into the database. We then find the deck by its ID and
    // assert that it is the same deck was created.
    @Test
    public void givenCreateDeckWhenLoadTheDeckThenExpectSameDeck() {
        Deck deck = new Deck("Norwegian Level A1-04",
                "Familiar everyday expressions and very basic phrases", 1, "NORWEGIAN", FALSE);
        Deck savedDeck = deckRepository.save(deck);
        assertThat(deckRepository.findById(savedDeck.getId()).get()).isEqualTo(deck);
    }

    // Test case creates and deletes a deck. It asserts whether the deck deletion is successful.
    @Test
    public void givenDeleteDeckByIdWhenLoadTheDeckThenExpectNoDeck() {
        Deck deck = new Deck("Norwegian Level A1-04",
                "Familiar everyday expressions and very basic phrases", 1, "NORWEGIAN", FALSE);
        Deck savedDeck = deckRepository.save(deck);
        assertThat(deckRepository.findById(savedDeck.getId()).get()).isEqualTo(deck);
        deckRepository.deleteById(savedDeck.getId());
        assertThat(deckRepository.findById(savedDeck.getId()).isPresent()).isFalse();
    }

    // Test case creates 2 decks with the same name but different user's id and saves it into the database. We then
    // find the deck by its name and user id, then assert that it is the same deck was created and is not equal
    // deck with different user id
    @Test
    public void givenFindDeckByDeckNameAndUserIdWhenLoadTheDecksThenExpectTheSameDeck() {
        Deck deck1 = new Deck("Norwegian Level A1-01",
                "Familiar everyday expressions and very basic phrases", 1, "NORWEGIAN", FALSE);
        Deck deck2 = new Deck("Norwegian Level A1-01",
                "Familiar everyday expressions and very basic phrases", 2, "NORWEGIAN", FALSE);
        Deck savedDeck1 = deckRepository.save(deck1);
        Deck savedDeck2 = deckRepository.save(deck2);
        assertThat(deckRepository.findById(savedDeck1.getId()).get()).isEqualTo(deck1);
        assertThat(deckRepository.findById(savedDeck2.getId()).get()).isEqualTo(deck2);
        assertThat(deckRepository.findByDeckNameAndUserId("Norwegian Level A1-01", 1l))
                .get().isEqualTo(deck1);
        assertThat(deckRepository.findByDeckNameAndUserId("Norwegian Level A1-01", 2l))
                .get().isNotEqualTo(deck1);
    }

    // Test case creates and deletes all decks. It asserts whether the decks deletion is successful.
    @Test
    public void givenDeleteAllWhenLoadDecksThenExpectNoDeck() {
        saveMockDecks();
        Iterable<Deck> decksByUserId = deckRepository.findDecksByUserId(1l);
        assertThat(deckRepository.findDecksByUserId(1l)).hasSize(5);
        assertThat(deckRepository.findDecksByUserId(3l)).hasSize(3);
        deckRepository.deleteAll(decksByUserId);
        assertThat(deckRepository.findDecksByUserId(1l)).isEmpty();
        assertThat(deckRepository.findDecksByUserId(3l)).hasSize(3);
    }

    // Test case creates some decks. It asserts whether the size of shared decks is correct.
    @Test
    public void givenFindDecksBySharedAndUserIdIsNotWhenLoadDecksThenExpectCorrectDecksSize() {
        saveMockDecks();
        assertThat(deckRepository.findDecksBySharedAndUserIdIsNot(TRUE, 1l)).hasSize(3);
    }

    // Creating and saving decks in db.
    private void saveMockDecks() {
        Deck norwegianA1_01 = new Deck("Norwegian Level A1-01", "Familiar everyday expressions and very basic phrases",
                1, "NORWEGIAN", TRUE);
        Deck norwegianA1_02 = new Deck("Norwegian Level A1-02", "Familiar everyday expressions and very basic phrases",
                1, "NORWEGIAN", TRUE);
        Deck norwegianA1_03 = new Deck("Norwegian Level A1-03", "Familiar everyday expressions and very basic phrases",
                1, "NORWEGIAN", FALSE);
        Deck norwegianA1_04 = new Deck("Norwegian Level A1-04", "Familiar everyday expressions and very basic phrases",
                1, "NORWEGIAN", FALSE);
        Deck norwegianA1_05 = new Deck("Norwegian Level A1-05", "Familiar everyday expressions and very basic phrases",
                1, "NORWEGIAN", FALSE);
        Deck norwegianB1_01 = new Deck("Norwegian Level B1-01", "Familiar matters regularly encountered in work, school, leisure, etc.",
                3, "NORWEGIAN", FALSE);
        Deck norwegianB1_02 = new Deck("Norwegian Level B1-02", "Familiar matters regularly encountered in work, school, leisure, etc.",
                3, "NORWEGIAN", TRUE);
        Deck norwegianB1_03 = new Deck("Norwegian Level B1-03", "Familiar matters regularly encountered in work, school, leisure, etc.",
                3, "NORWEGIAN", TRUE);
        Deck norwegianC1_01 = new Deck("Norwegian Level C1-01", "Complex tasks related to work and study",
                4, "NORWEGIAN", TRUE);
        Deck norwegianC1_02 = new Deck("Norwegian Level C1-02", "Complex tasks related to work and study",
                4, "NORWEGIAN", FALSE);


        List<Deck> decks = Arrays.asList(norwegianA1_01, norwegianA1_02, norwegianA1_03, norwegianA1_04, norwegianA1_05,
                norwegianB1_01, norwegianB1_02, norwegianB1_03, norwegianC1_01, norwegianC1_02);
        deckRepository.saveAll(decks);
    }

}
