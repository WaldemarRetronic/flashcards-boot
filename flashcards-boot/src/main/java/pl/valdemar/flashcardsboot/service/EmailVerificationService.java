package pl.valdemar.flashcardsboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.model.EmailVerification;
import pl.valdemar.flashcardsboot.repository.EmailVerificationRepository;

import java.util.Optional;

@Slf4j
@Service
public class EmailVerificationService {

    private final EmailVerificationRepository repository;

    @Autowired
    public EmailVerificationService(EmailVerificationRepository repository) {
        this.repository = repository;
    }

    public String generateVerification(String username) {
        if (!repository.existsByUsername(username)) {

            EmailVerification verification = new EmailVerification(username);
            verification = repository.save(verification);
            return verification.getVerificationId();
        }
        return getVerificationIdByUsername(username);
    }

    public String getVerificationIdByUsername(String username) {
        EmailVerification verification = repository.findByUsername(username);

        if (verification != null) {
            return verification.getVerificationId();
        }
        return null;
    }

    public String getUsernameForVerificationId(String verificationId) {
        Optional<EmailVerification> verification = repository.findById(verificationId);

        if (verification.isPresent()) {

            return verification.get().getUsername();
        }
        return null;
    }
}
