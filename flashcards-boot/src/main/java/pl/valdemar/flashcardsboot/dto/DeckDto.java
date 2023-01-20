package pl.valdemar.flashcardsboot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DeckDto {

    @NotEmpty(message = "Deck's name can't be empty.")
    @NotBlank(message = "Deck's name can't be blank.")
    @Pattern(message = "Deck's name can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 25, message = "Length of deck's name must be between 5 and 25.")
    private String deckName;

    @NotEmpty(message = "Description's can't be empty.")
    @NotBlank(message = "Description's can't be blank")
    @Pattern(message = "Description's name can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 250, message = "Length of description's must be between 5 and 250.")
    private String description;

    @NotEmpty(message = "Category's can't be empty.")
    @NotBlank(message = "Category's can't be blank")
    @Pattern(message = "Category's can't start and end with whitespace.", regexp = "(\\S.*\\S)")
    @Size(min = 5, max = 25, message = "Length of description's name must be between 5 and 25.")
    private String category;

    private boolean shared;

}
