package pl.valdemar.flashcardsboot.dto;

import javax.validation.constraints.NotEmpty;

public class PasswordDto {

    @NotEmpty(message = "Enter current password")
    private String currentPassword;

    @NotEmpty(message = "Enter a password")
    private String newPassword;

    @NotEmpty(message = "Confirm your password")
    private String confirmPassword;

    public PasswordDto() {}

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
