package pl.valdemar.flashcardsboot.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
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
    @Size(min = 5,  max = 10, message = "Length of deck's name must be between 5 and 10.")
    @Column(name = "DECK_NAME")
    private String deckName;

    @NotEmpty(message = "Description's can't be empty.")
    @NotBlank(message = "Description's can't be blank")
    @Pattern(message = "Description's name can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5,  max = 30, message = "Length of description's must be between 5 and 30.")
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private long userId;

    @NotEmpty(message = "Category's can't be empty.")
    @NotBlank(message = "Category's can't be blank")
    @Pattern(message = "Category's can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5,  max = 10, message = "Length of description's name must be between 5 and 10.")
    @Column(name = "CATEGORY")
    private String category;

    // == constructors ==
    public Deck() {
    }

    public Deck(String deckName, String description, int userId, String category) {
        this.deckName = deckName;
        this.description = description;
        this.userId = userId;
        this.category = category;
    }

    public Deck(String deckName, String description) {
        this.deckName = deckName;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;
        Deck deck = (Deck) o;
        return Objects.equal(deckName, deck.deckName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(deckName);
    }

}
