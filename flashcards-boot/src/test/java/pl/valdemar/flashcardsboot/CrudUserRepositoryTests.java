package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.model.EmailVerification;
import pl.valdemar.flashcardsboot.model.Flashcard;
import pl.valdemar.flashcardsboot.repository.EmailVerificationRepository;
import pl.valdemar.flashcardsboot.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CrudUserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    // Test case creates a new user and saves it into the database. We then find the user by its ID and
    // assert that it is the same user was created.
    @Test
    public void givenCreateUserWhenLoadTheUserThenExpectSameUser() {
        ApplicationUser user = new ApplicationUser("username", "password", true,
                false, false);
        ApplicationUser savedUser = userRepository.save(user);
        assertThat(userRepository.findById(savedUser.getId()).get()).isEqualTo(user);
    }

    // Test case creates and deletes a user. It asserts whether the user deletion is successful.
    @Test
    public void givenDeleteUserWhenLoadTheUserThenExpectNoUser() {
        ApplicationUser user = new ApplicationUser("username", "password", true,
                false, false);
        ApplicationUser savedUser = userRepository.save(user);
        assertThat(userRepository.findById(savedUser.getId()).get()).isEqualTo(user);
        userRepository.delete(savedUser);
        assertThat(userRepository.findById(savedUser.getId()).isPresent()).isFalse();
    }

    // Test case creates a new user and saves it into the database. We then find the user by name and
    // assert that it is the same user was created.
    @Test
    public void givenFindByUsernameWhenLoadTheUserThenExpectSameUser() {
        ApplicationUser user = new ApplicationUser("username", "password", true,
                false, false);
        ApplicationUser savedUser = userRepository.save(user);
        assertThat(userRepository.findByUsername("username")).isEqualTo(user);
    }
}
