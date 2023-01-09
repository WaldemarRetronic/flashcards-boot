package pl.valdemar.flashcardsboot.service;

import pl.valdemar.flashcardsboot.model.Flashcard;

import java.util.List;

public interface StudyService {

    Flashcard getNextFlashcard();
    List<Flashcard> getFlashcards();
    void setFlashcards(List<Flashcard> flashcards);
    void update(String answer);
    int getCorrect();
    int getWrong();
    int getCardsNumber();
    double getRatio();
    void reset();
}
