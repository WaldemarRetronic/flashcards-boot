package pl.valdemar.flashcardsboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"verificationId", "username"})
@Entity
@Table(name = "EMAIL_VERIFICATIONS")
public class EmailVerification {

    @Id
    @GeneratedValue(generator = "UUID_GENERATOR")
    @GenericGenerator(name = "UUID_GENERATOR", strategy = "org.hibernate.id.UUIDGenerator")
    private String verificationId;

    private String username;

    public EmailVerification(String username) {
        this.username = username;
    }
}
