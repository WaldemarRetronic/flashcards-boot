package pl.valdemar.flashcardsboot.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.valdemar.flashcardsboot.service.StudyService;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@Scope("session")
public class MessageGeneratorImpl implements MessageGenerator {

    // == fields ==
    private final StudyService studyService;

    // == constructors ==
    public MessageGeneratorImpl(StudyService studyService) {
        this.studyService = studyService;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("studyService = {} ", studyService);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Nice work, you've recalled " +
                studyService.getCardsNumber() +
                " words today!";
    }

    @Override
    public String getResultMessage() {
        double ratio = studyService.getRatio();
        String result = "You got correct " + studyService.getCorrect() + ", and " + studyService.getWrong() + " wrong answers.\n";
        if (ratio <= 10.0) {
            return result + "Complete disaster. What is wrong with you man!!!";
        } else if (ratio <= 25 ) {
            return result + "Very very very bad!!!";
        } else if (ratio <= 50) {
            return result + "You could do it better!";
        } else if (ratio <= 75) {
            return result + "It's not so bad. Try improve it!";
        } else if (ratio <= 90) {
            return result + "Very good!";
        } else if (ratio <= 99.9999999) {
            return result + "Almost perfect, excellent job!";
        } else {
            return result + "Perfect. You are great!!!";
        }
    }

    @Override
    public String getEmptyDeckMessage() {
        return "Deck is empty! Please add some flashcards to start learning.";
    }

    @Override
    public String getStartMessage() {
        return "Let's get started.";
    }


}


