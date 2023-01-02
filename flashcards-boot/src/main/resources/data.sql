-- INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION) VALUES(1, 'Rapid Spring Boot Application Development', 'Spring', 4, 'Spring Boot gives all the power of the Spring Framework without all of the complexity');
-- INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION) VALUES(2, 'Getting Started with Spring Security DSL','Spring', 3,  'Learn Spring Security DSL in easy steps');
-- INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION) VALUES(3, 'Scalable, Cloud Native Data Applications', 'Spring', 4,  'Manage Cloud based applications with Spring Boot');
-- INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION) VALUES(4, 'Fully Reactive: Spring, Kotlin, and JavaFX Playing Together', 'Spring', 3, 'Unleash the power of Reactive Spring with Kotlin and Spring Boot');
-- INSERT INTO COURSES(ID, NAME, CATEGORY, RATING, DESCRIPTION) VALUES(5, 'Getting Started with Spring Cloud Kubernetes', 'Spring', 5, 'Master Spring Boot application deployment with Kubernetes');

INSERT INTO USERS(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, EMAIL, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('Adam', 'Smith', 'smith', 'password', 'smith@example.com', TRUE, FALSE, FALSE);
INSERT INTO USERS(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, EMAIL, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('John', 'Kelly', 'kelly', 'password', 'kelly@example.com', FALSE, FALSE, FALSE);

INSERT INTO DECKS(DECK_NAME, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-01', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-02', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-03', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, DESCRIPTION, USER_ID) VALUES('Norwegian Level B1-01', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2);
INSERT INTO DECKS(DECK_NAME, DESCRIPTION, USER_ID) VALUES('Norwegian Level B1-02', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2);

INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('farvel', 'goodbye', 1, 1, 'Basic');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kveld', 'evening', 1, 1, 'Basic');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('liten', 'small', 1, 1, 'Reversed');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('morgen', 'morning', 1, 2, 'Reversed');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('natt', 'night', 1, 2, 'Reversed');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('myk', 'soft', 2, 4, 'Type In Answer');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('støyende', 'noisy', 2, 4, 'Type In Answer');
INSERT INTO FLASHCARDS(NATIVE_NAME, FOREIGN_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kraftig', 'powerful', 2, 4, 'Type In Answer');

