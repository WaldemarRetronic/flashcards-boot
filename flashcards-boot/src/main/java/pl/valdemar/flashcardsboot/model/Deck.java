package pl.valdemar.flashcardsboot.model;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    @Column(name = "DECK_NAME")
    private String deckName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private long userId;

    // == constructors ==
    public Deck() {
    }

    public Deck(String deckName, String description, int userId) {
        this.deckName = deckName;
        this.description = description;
        this.userId = userId;
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
