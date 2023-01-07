
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('smith@example.com', 'password', TRUE, FALSE, FALSE);
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('kelly@example.com', 'password', FALSE, FALSE, FALSE);

INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-01', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-02', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID) VALUES('Norwegian Level A1-03', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 1);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID) VALUES('Norwegian Level B1-01', 'NORWEGIAN', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID) VALUES('Norwegian Level B1-02', 'NORWEGIAN', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2);

INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('farvel', 'goodbye', 1, 1, 'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kveld', 'evening', 1, 1, 'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('liten', 'small', 1, 1, 'reversed');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('morgen', 'morning', 1, 2, 'reversed');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('natt', 'night', 1, 2, 'reversed');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('myk', 'soft', 2, 4, 'type_in_answer');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('støyende', 'noisy', 2, 4, 'type_in_answer');
INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kraftig', 'powerful', 2, 4, 'type_in_answer');

