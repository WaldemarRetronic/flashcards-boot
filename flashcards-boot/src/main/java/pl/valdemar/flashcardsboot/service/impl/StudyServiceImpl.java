package pl.valdemar.flashcardsboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.service.StudyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@Scope("session")
public class StudyServiceImpl implements StudyService {

    // == fields ==
    private List<Flashcard> flashcards;
    private int correct;
    private int wrong;
    private int cardsNumber;
    private double ratio;
    private final Random random = new Random();


    // == public methods ==
    @Override
    public int getCardsNumber() {
        return cardsNumber;
    }

    @Override
    public Flashcard getNextFlashcard() {
        if (flashcards.isEmpty()) return null;
        int idx = random.nextInt(flashcards.size());
        Flashcard flashcard = flashcards.get(idx);
        flashcards.remove(idx);
        return flashcard;
    }

    @Override
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    @Override
    public int getCorrect() {
        return this.correct;
    }

    @Override
    public int getWrong() {
        return this.wrong;
    }

    @Override
    public void setFlashcards(List<Flashcard> flashcards) {
        List<Flashcard> concatFlashcards = new ArrayList<>();
        concatFlashcards.addAll(generateReversed(flashcards));
        concatFlashcards.addAll(flashcards);
        this.flashcards = new ArrayList<>(concatFlashcards);
        cardsNumber = this.flashcards.size();
    }

    public void update(String answer) {
        if (answer.equals("yes")) {
            correct++;
        } else if (answer.equals("no")) {
            wrong++;
        } else throw new IllegalArgumentException();
        ratio = calculateRatio();
    }

    @Override
    public double getRatio() {
        return ratio;
    }

    @Override
    public void reset() {
        correct = 0;
        wrong = 0;
    }

    // == private methods ==
    private double calculateRatio() {
        return correct * 100 / (correct + wrong);
    }

    private List<Flashcard> generateReversed(List<Flashcard> flashCards) {
        return flashCards.stream()
                .filter(flashCard -> flashCard.getVariety().equals("reversed"))
                .map(this::reverseFlashcard)
                .collect(Collectors.toList());
    }

    private Flashcard reverseFlashcard(Flashcard flashCard) {
        Flashcard reversedFlashcard = new Flashcard();
        reversedFlashcard.setForeignName(flashCard.getNativeName());
        reversedFlashcard.setNativeName(flashCard.getForeignName());
        return reversedFlashcard;
    }
}
