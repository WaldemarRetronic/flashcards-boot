package pl.valdemar.flashcardsboot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class PasswordDto {

    @NotEmpty(message = "Enter current password")
    private String currentPassword;

    @Pattern(message = "Min 6 characters: 1-uppercase 1-lowercase, 1-number.",
            regexp = "^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=[^0-9]*[0-9]).{6,}$")
    private String newPassword;

    @Pattern(message = "Min 6 characters: 1-uppercase 1-lowercase, 1-number.",
            regexp = "^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=[^0-9]*[0-9]).{6,}$")
    private String confirmPassword;

    public PasswordDto() {
    }

    public PasswordDto(String currentPassword, String newPassword, String confirmPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
