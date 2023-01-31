package pl.valdemar.flashcardsboot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class FlashcardDto {

    @NotEmpty(message = "Expression can't be empty.")
    @NotBlank(message = "Expression can't be blank")
    @Pattern(message = "Expression can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 1, max = 250, message = "Length of description's name must be between 1 and 250.")
    private String nativeName;

    @NotEmpty(message = "Expression can't be empty.")
    @NotBlank(message = "Expression can't be blank")
    @Pattern(message = "Expression can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 1, max = 250, message = "Length of description's name must be between 1 and 250.")
    private String foreignName;

    private String variety;

    private long deckId;

    public FlashcardDto(long deckId) {
        this.deckId = deckId;
    }
}
