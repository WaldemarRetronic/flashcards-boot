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
@EqualsAndHashCode(of = {"deckName", "userId"})
@Entity
@Table(name = "DECKS")
public class Deck {

    // == fields ==
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Deck's name can't be empty.")
    @NotBlank(message = "Deck's name can't be blank.")
    @Pattern(message = "Deck's name can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 25, message = "Length of deck's name must be between 5 and 25.")
    @Column(name = "DECK_NAME")
    private String deckName;

    @NotEmpty(message = "Description's can't be empty.")
    @NotBlank(message = "Description's can't be blank")
    @Pattern(message = "Description's name can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 250, message = "Length of description's must be between 5 and 250.")
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private long userId;

    @NotEmpty(message = "Category's can't be empty.")
    @NotBlank(message = "Category's can't be blank")
    @Pattern(message = "Category's can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 25, message = "Length of description's name must be between 5 and 25.")
    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SHARED")
    private boolean shared;

    // == constructors ==

    public Deck(String deckName, String description, long userId, String category, boolean shared) {
        this.deckName = deckName;
        this.description = description;
        this.userId = userId;
        this.category = category;
        this.shared = shared;
    }
}
