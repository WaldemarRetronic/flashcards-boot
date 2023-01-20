package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.repository.DeckRepository;
import pl.valdemar.flashcardsboot.repository.FlashcardRepository;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CrudFlashcardRepositoryTests {

    @Autowired
    private FlashcardRepository flashcardRepository;

    // Test case creates a new flashcard and saves it into the database. We then find the flashcard by its ID and
    // assert that it is the same flashcard was created.
    @Test
    public void givenCreateFlashcardWhenLoadTheFlashcardThenExpectSameFlashcard() {
        Flashcard flashcard = new Flashcard("innledning", "introduction",
                1, 1, "basic");
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);
        assertThat(flashcardRepository.findById(savedFlashcard.getId()).get()).isEqualTo(flashcard);
    }

    // Test case creates and deletes a flashcard. It asserts whether the flashcard deletion is successful.
    @Test
    public void givenDeleteFlashcardByIdWhenLoadTheFlashcardThenExpectNoFlashcard() {
        Flashcard flashcard = new Flashcard("innledning", "introduction",
                1, 1, "basic");
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);
        assertThat(flashcardRepository.findById(savedFlashcard.getId()).get()).isEqualTo(flashcard);
        flashcardRepository.deleteById(savedFlashcard.getId());
        assertThat(flashcardRepository.findById(savedFlashcard.getId()).isPresent()).isFalse();
    }

    // Test case creates and deletes all flashcards. It asserts whether the flashcards deletion is successful.
    @Test
    public void givenDeleteAllWhenLoadFlashcardsThenExpectNoFlashcard() {
        saveMockFlashcards();
        Iterable<Flashcard> flashcardsByUserId = flashcardRepository.findByUserId(1l);
        assertThat(flashcardRepository.findByUserId(1l)).hasSize(5);
        assertThat(flashcardRepository.findByUserId(2l)).hasSize(3);
        flashcardRepository.deleteAll(flashcardsByUserId);
        assertThat(flashcardRepository.findByUserId(1l)).isEmpty();
        assertThat(flashcardRepository.findByUserId(2l)).hasSize(3);
    }

    // Creating and saving flashcards in db.
    private void saveMockFlashcards() {
        Flashcard flashcard_01 = new Flashcard("introduction", "innledning",
                1, 1, "basic");
        Flashcard flashcard_02 = new Flashcard("Norwegian", "norsk",
                1, 1, "basic");
        Flashcard flashcard = new Flashcard("part", "del",
                1, 1, "basic");
        Flashcard flashcard_03 = new Flashcard("Norway", "Norge",
                1, 1, "basic");
        Flashcard flashcard_04 = new Flashcard("pupil", "elev",
                1, 1, "basic");
        Flashcard flashcard_05 = new Flashcard("book", "bok",
                1, 1, "basic");
        Flashcard flashcard_06 = new Flashcard("kind", "snill",
                2, 1, "basic");
        Flashcard flashcard_07 = new Flashcard("after", "etter",
                2, 1, "basic");
        Flashcard flashcard_08 = new Flashcard("this", "dette",
                2, 1, "basic");


        List<Flashcard> flashcards = Arrays.asList(flashcard_01, flashcard_02, flashcard_03, flashcard_04,
                flashcard_05, flashcard_06, flashcard_07, flashcard_08);
        flashcardRepository.saveAll(flashcards);
    }

}
