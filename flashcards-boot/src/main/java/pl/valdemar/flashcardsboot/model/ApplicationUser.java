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
@Table(name = "USERS")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String firstName;
//    private String lastName;
    private String username;
    private String email;
    private String password;
    private boolean verified;
    private boolean locked;
    @Column(name = "ACC_CRED_EXPIRED")
    private boolean accountCredentialsExpired;

//    public ApplicationUser(String firstName, String lastName, String username, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
    public ApplicationUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public ApplicationUser() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationUser)) return false;
        ApplicationUser that = (ApplicationUser) o;
        return Objects.equal(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
