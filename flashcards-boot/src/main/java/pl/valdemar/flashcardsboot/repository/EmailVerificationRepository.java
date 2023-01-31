package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.valdemar.flashcardsboot.model.EmailVerification;

@Repository
public interface EmailVerificationRepository extends CrudRepository<EmailVerification, String> {

    EmailVerification findByUsername(String userName);

    boolean existsByUsername(String userName);
}
