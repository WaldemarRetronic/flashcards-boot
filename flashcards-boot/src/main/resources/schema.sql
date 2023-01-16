CREATE TABLE USERS(
    ID BIGINT NOT NULL auto_increment,
    USERNAME VARCHAR(50),
    PASSWORD VARCHAR(100),
    VERIFIED BOOLEAN NOT NULL,
    LOCKED BOOLEAN NOT NULL,
    ACC_CRED_EXPIRED BOOLEAN NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE DECKS (
    ID BIGINT NOT NULL auto_increment,
    DECK_NAME VARCHAR(255),
    CATEGORY VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    USER_ID BIGINT NOT NULL,
    SHARED BOOLEAN NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE FLASHCARDS (
    ID BIGINT NOT NULL auto_increment,
    NATIVE_NAME VARCHAR(255) NOT NULL,
    FOREIGN_NAME VARCHAR(255) NOT NULL,
    USER_ID BIGINT NOT NULL,
    DECK_ID BIGINT NOT NULL,
    VARIETY VARCHAR(100) NOT NULL,
    DECK_NAME VARCHAR(255),
    PRIMARY KEY (ID),
    FOREIGN KEY (USER_ID) references USERS(ID),
    FOREIGN KEY (DECK_ID) references DECKS(ID)
);

CREATE TABLE EMAIL_VERIFICATIONS(
    VERIFICATION_ID VARCHAR(50),
    USERNAME VARCHAR(50),
    PRIMARY KEY (VERIFICATION_ID)
);

-- ALTER TABLE DECKS ADD CONSTRAINT FK_ID FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
-- ON UPDATE CASCADE ON DELETE NO ACTION ;

