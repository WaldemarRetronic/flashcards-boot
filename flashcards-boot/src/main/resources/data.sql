
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('smith@example.com', 'password', TRUE, FALSE, FALSE);
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('kelly@example.com', 'password', TRUE, FALSE, FALSE);
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('waldemar@example.com', 'password', TRUE, FALSE, FALSE);
INSERT INTO USERS(USERNAME, PASSWORD, VERIFIED, LOCKED, ACC_CRED_EXPIRED) VALUES('tutik@example.com', 'password', TRUE, FALSE, FALSE);

INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID, SHARED) VALUES('Norwegian Level A1-01', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 4, TRUE);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID, SHARED) VALUES('Norwegian Level A1-02', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 4, FALSE);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID, SHARED) VALUES('Norwegian Level A1-03', 'NORWEGIAN', 'Familiar everyday expressions and very basic phrases', 4, FALSE);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID, SHARED) VALUES('Norwegian Level B1-01', 'NORWEGIAN', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2, TRUE);
INSERT INTO DECKS(DECK_NAME, CATEGORY, DESCRIPTION, USER_ID, SHARED) VALUES('Norwegian Level B1-02', 'NORWEGIAN', 'Familiar matters regularly encountered in work, school, leisure, etc.', 2, FALSE);

-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('farvel', 'goodbye', 1, 1, 'basic');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kveld', 'evening', 1, 1, 'basic');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('liten', 'small', 1, 1, 'reversed');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('morgen', 'morning', 1, 2, 'reversed');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('natt', 'night', 1, 2, 'reversed');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('myk', 'soft', 2, 4, 'type_in_answer');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('støyende', 'noisy', 2, 4, 'type_in_answer');
-- INSERT INTO FLASHCARDS(FOREIGN_NAME, NATIVE_NAME, USER_ID, DECK_ID, VARIETY) VALUES ('kraftig', 'powerful', 2, 4, 'type_in_answer');

INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('innledning (c.)','introduction',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('nå','now',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('skal','shall',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('snakke','to speak',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('norsk','Norwegian',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('nå skal vi snakke norsk','now let''s speak Norwegian; now we are going to speak Norwegian',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('første','first',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('del (c.)','part',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('god','good',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('morgen (c.)','morning',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('vær','be',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å være','to be',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('så','so',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('snill','kind',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å','to',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('høre','to hear',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('etter','after',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('høre etter','to listen',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('vær så snill å høre etter','be so kind as to listen; please listen',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('jeg','I',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('er','am, is, are',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('lærer (en) (c.)','(the) teacher',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De','you (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('elev (en) (c.)','(the) pupil, (the) student',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('ikke','not',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('jeg snakker','I speak; I am speaking',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('i','in',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('Norge (n.)','Norway',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('man','one',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('man snakker','one speaks',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('man snakker norsk','one speaks Norwegian; Norwegian is spoken; they speak Norwegian',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('dette','this',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('et (n.)','a, one 1',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('bord (n.)','table',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('en (c.)','a, one 1',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('bok (c.)','book',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('bok(en)','the book',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('ligger','is lying; lies',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å ligge','to lie',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('på','on',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('bord(et) (n.)','(the) table',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('står','stands; is standing',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å stå','to stand',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('dagligstue(n) (c.)','(the) sitting-room; (the) living-room',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('det (n.)','that; it',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('stol (c.)','chair',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De sitter','you are sitting; you sit (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å sitte','to sit',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('ved','at; by',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('har','have; has',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å ha','to have',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hånd(en) (c.)','(the) hand',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('i hånden','in your hand',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('ser','see; sees',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å se','to see',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De ser i boken','you are looking at the book',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De lytter','you are listening; you listen (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å lytte','to listen',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('til','to; till',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('min','my',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('stemme (c.)','voice',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De lærer','you are learning; you learn (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å lære','to learn',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å forstå','to understand',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å lese','to read',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('og','and',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å skrive','to write',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('jeg taler','I speak; I am speaking',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å tale','to speak, talk',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('langsomt','slowly',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('når','when',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De forstår','you understand',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('fort','quickly',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('De forstår ikke','you do not understand (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('annen','second',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('dag (c.)','day',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('god dag','good day; good morning; good afternoon; good evening',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hvordan','how',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hvordan har De det?','how are you? (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('takk','thank you; thanks',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('bra','good; very well',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å svare','to answer, reply',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('mine (pl.)','my',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('spørsmal (n.)','question(s)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hvem','who',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('eller','or',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('også','also; as well; too',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('nei','no',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('snakker De norsk?','do you speak Norwegian? (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('ja','yes',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('lite grann','a little',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hva','what',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hvor','where',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('den (c.)','it',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hva gjør De?','what are you doing?',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('å gjøre','to do',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hva lytter De til?','what are you listening to? (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('Deres','your (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('hva lærer De nå?','what are you learning now? (formal)',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('meg','me',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('Dem (acc.)','you',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('meget','very; much',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('godt (adv.)','well; good',4,1,'basic');
INSERT INTO FLASHCARDS(FOREIGN_NAME,NATIVE_NAME,USER_ID,DECK_ID,VARIETY) VALUES ('da forstår jeg Dem ikke','then I do not understand you (formal)',4,1,'basic');

