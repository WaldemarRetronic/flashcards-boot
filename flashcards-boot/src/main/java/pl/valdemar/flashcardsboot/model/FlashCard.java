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
@Table()
public class FlashCard {

    // == fields ==
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NATIVE_NAME")
    private String nativeName;

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

    public FlashCard() {
    }

    public FlashCard(String nativeName, String foreignName, int userId, int deckId, String variety) {
        this.nativeName = nativeName;
        this.foreignName = foreignName;
        this.userId = userId;
        this.deckId = deckId;
        this.variety = variety;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCard)) return false;
        FlashCard flashCard = (FlashCard) o;
        return Objects.equal(nativeName, flashCard.nativeName) && Objects.equal(foreignName, flashCard.foreignName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nativeName, foreignName);
    }

}
