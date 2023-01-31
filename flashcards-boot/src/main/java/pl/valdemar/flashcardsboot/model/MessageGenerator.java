package pl.valdemar.flashcardsboot.model;

public interface MessageGenerator {
    String getMainMessage();

    String getResultMessage();

    String getEmptyDeckMessage();

    String getStartMessage();
}
