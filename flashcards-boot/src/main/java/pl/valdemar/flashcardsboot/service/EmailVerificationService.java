package pl.valdemar.flashcardsboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.FlashcardsBootApplication;
import pl.valdemar.flashcardsboot.model.EmailVerification;
import pl.valdemar.flashcardsboot.repository.EmailVerificationRepository;

import java.util.Optional;

@Service
public class EmailVerificationService {

    private static Logger logger = LoggerFactory.getLogger(FlashcardsBootApplication.class);

    private final EmailVerificationRepository repository;

    @Autowired
    public EmailVerificationService(EmailVerificationRepository repository) {
        this.repository = repository;
    }

    public String generateVerification(String username) {
        logger.info("called generateVerification with username {}", username);
        if (!repository.existsByUsername(username)) {
            logger.info("called generateVerification with username {} doesn't exist.", username);

            EmailVerification verification = new EmailVerification(username);
            verification = repository.save(verification);
            return verification.getVerificationId();
        }
        return getVerificationIdByUsername(username);
    }

    public String getVerificationIdByUsername(String username) {
        EmailVerification verification = repository.findByUsername(username);
        logger.info("called getVerificationIdByUsername with username {}", username);

        if(verification != null) {
            logger.info("called getVerificationIdByUsername with verificationId {}", verification.getVerificationId());
            return verification.getVerificationId();
        }
        return null;
    }

    public String getUsernameForVerificationId(String verificationId) {
        Optional<EmailVerification> verification = repository.findById(verificationId);
        logger.info("called getUsernameForVerificationId with verificationId {}", verificationId);

        if(verification.isPresent()) {
            logger.info("verification is present");

            return verification.get().getUsername();
        }
        return null;
    }
}
