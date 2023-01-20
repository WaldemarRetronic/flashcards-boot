package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.valdemar.flashcardsboot.model.EmailVerification;
import pl.valdemar.flashcardsboot.repository.EmailVerificationRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CrudEmailVerificationRepositoryTests {

    @Autowired
    private EmailVerificationRepository emailRepository;

    // Test case creates a new verification and saves it into the database. We then find the verification
    // by its ID and assert that it is the same verification was created.
    @Test
    public void givenGenerateVerificationWhenLoadTheVerificationThenExpectSameVerification() {
        EmailVerification verification = new EmailVerification("username");
        EmailVerification savedVerification = emailRepository.save(verification);
        assertThat(emailRepository.findById(savedVerification.getVerificationId()).get()).isEqualTo(verification);
    }

    // Test case creates a new verification and saves it into the database. It asserts whether the verification exists.
    @Test
    public void givenExistsByUsernameWhenLoadTheVerificationThenExpectTrue() {
        EmailVerification verification = new EmailVerification("username");
        emailRepository.save(verification);
        assertThat(emailRepository.existsByUsername("username")).isTrue();
    }

    // Test case creates a new verification and saves it into the database and deletes. It asserts whether
    // the verification doesn't exist.
    @Test
    public void givenExistsByUsernameWhenLoadTheVerificationThenExpectFalse() {
        EmailVerification verification = new EmailVerification("username");
        emailRepository.delete(verification);
        assertThat(emailRepository.existsByUsername("username")).isFalse();
    }

    // Test case creates a new verification and saves it into the database. We then find the verification by name and
    // assert that it is the same verification was created.
    @Test
    public void givenFindByUsernameWhenLoadTheVerificationThenExpectSameVerification() {
        EmailVerification verification = new EmailVerification("username");
        emailRepository.save(verification);
        assertThat(emailRepository.findByUsername("username")).isEqualTo(verification);
    }
}
