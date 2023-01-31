package pl.valdemar.flashcardsboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmailDto {

    @NotEmpty(message = "Enter current password")
    private String currentPassword;

    @NotEmpty(message = "Enter an email")
    @Email(message = "Email is not valid")
    private String newEmail;

    @NotEmpty(message = "Enter an email")
    @Email(message = "Email is not valid")
    private String confirmEmail;

    public EmailDto() {
    }

    public EmailDto(String currentPassword, String newEmail, String confirmEmail) {
        this.currentPassword = currentPassword;
        this.newEmail = newEmail;
        this.confirmEmail = confirmEmail;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
}
