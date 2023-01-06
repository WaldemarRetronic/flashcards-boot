package pl.valdemar.flashcardsboot.dto;

import lombok.Data;

@Data
public class FlashcardDto {

    private String nativeName;

    private String foreignName;

    private String variety;

    private long deckId;

    public FlashcardDto(long deckId) {
        this.deckId = deckId;
    }
}
