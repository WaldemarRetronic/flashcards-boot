package pl.valdemar.flashcardsboot.model;

import com.google.common.base.Objects;

import javax.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
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

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + id +
                ", nativeName='" + nativeName + '\'' +
                ", foreignName='" + foreignName + '\'' +
                ", userId=" + userId +
                ", deckId=" + deckId +
                ", variety='" + variety + '\'' +
                ", deckName='" + deckName + '\'' +
                '}';
    }
}
