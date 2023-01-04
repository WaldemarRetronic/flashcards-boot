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
        log.info("called generateVerification with username {}", username);
        if (!repository.existsByUsername(username)) {
            log.info("called generateVerification with username {} doesn't exist.", username);

            EmailVerification verification = new EmailVerification(username);
            verification = repository.save(verification);
            return verification.getVerificationId();
        }
        return getVerificationIdByUsername(username);
    }

    public String getVerificationIdByUsername(String username) {
        EmailVerification verification = repository.findByUsername(username);
        log.info("called getVerificationIdByUsername with username {}", username);

        if (verification != null) {
            log.info("called getVerificationIdByUsername with verificationId {}", verification.getVerificationId());
            return verification.getVerificationId();
        }
        return null;
    }

    public String getUsernameForVerificationId(String verificationId) {
        Optional<EmailVerification> verification = repository.findById(verificationId);
        log.info("called getUsernameForVerificationId with verificationId {}", verificationId);

        if (verification.isPresent()) {
            log.info("verification is present");

            return verification.get().getUsername();
        }
        return null;
    }
}
