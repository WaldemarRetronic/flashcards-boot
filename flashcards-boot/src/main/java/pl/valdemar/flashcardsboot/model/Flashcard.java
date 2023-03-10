package pl.valdemar.flashcardsboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "FLASHCARDS")
public class Flashcard {

    // == fields ==
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Expression can't be empty.")
    @NotBlank(message = "Expression can't be blank")
    @Pattern(message = "Expression can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 1, max = 250, message = "Length of description's name must be between 1 and 250.")
    @Column(name = "NATIVE_NAME")
    private String nativeName;

    @NotEmpty(message = "Expression can't be empty.")
    @NotBlank(message = "Expression can't be blank")
    @Pattern(message = "Expression can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 1, max = 250, message = "Length of description's name must be between 1 and 250.")
    @Column(name = "FOREIGN_NAME")
    private String foreignName;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "DECK_ID")
    private long deckId;

    @Column(name = "VARIETY")
    private String variety;

    @Column(name = "DECK_NAME")
    private String deckName;

    public Flashcard(String nativeName, String foreignName, int userId, int deckId, String variety) {
        this.nativeName = nativeName;
        this.foreignName = foreignName;
        this.userId = userId;
        this.deckId = deckId;
        this.variety = variety;
    }

}
