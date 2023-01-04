package pl.valdemar.flashcardsboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {

    @NotEmpty(message = "Enter an email")
    @Email(message = "Email is not valid")
    private String username;

    @NotEmpty(message = "Enter a password")
    private String password;

    @NotEmpty(message = "Confirm your password")
    private String confirmPassword;


    public UserDto() {
    }

    public UserDto(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
