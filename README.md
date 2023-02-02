# flashcards
Web application to create and share basic text-only cards and review them. Application was developed in SpringBoot with Hibernate.

Flashcards

Flashcard is a pair of a question and answer. This is based on a paper flashcard with a question on one side and the answer on the back. After thinking, you click the Check button, and will be shown answer with the question remains visible. After confirming that you are correct or wrong will be displayed next card. Each flashcard can have different type:
  - basic - flashcard will be reviewed showing front as question and back as answer
  - reversed - flashcard will be reviewed twice, once like a basic and once showing back as question and front as answer
  - type_in_answer - front of flashcard is a question and answer has to be typed in

Decks

Deck is a set of flashcards to review in one session. Order of displayed flashcards during reviewing is random. While you're studying, it's shown number of cards reviewed and total number in deck. When session is over, you are presented result. 
'Deckname' is unique name identifying deck in your collection. Besides you can categorize decks by field category, and give description to each deck. As well, you can share your deck with the other users by specifying it in the field 'shared'. Your shared decks are not allowed to edit by other users.


Account

To get started you have to be logged in. You have to log in using username as your email. This is necessary for verification. Additionally, you can log in through your Google account. At any time you can remove your account.

