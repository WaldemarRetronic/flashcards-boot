package pl.valdemar.flashcardsboot.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.event.UserRegistrationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.service.EmailVerificationService;

import java.util.Base64;

@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

    private final JavaMailSender mailSender;
    private final EmailVerificationService verificationService;

    @Autowired
    public EmailVerificationListener(JavaMailSender mailSender, EmailVerificationService verificationService) {
        this.mailSender = mailSender;
        this.verificationService = verificationService;
    }

    public void onApplicationEvent(UserRegistrationEvent event) {
    	ApplicationUser user = event.getUser();
        String username = user.getUsername();
        String verificationId = verificationService.generateVerification(username);
        String email = event.getUser().getEmail();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Flashcards Account Verification");
        message.setText(getText(user, verificationId));
        message.setTo(email);
        mailSender.send(message);
    }
    
    private String getText(ApplicationUser user, String verificationId) {
    	String encodedVerificationId = new String(Base64.getEncoder().encode(verificationId.getBytes()));
    	StringBuffer buffer = new StringBuffer();
//        buffer.append("Dear ").append(user.getFirstName()).append(" ").append(user.getLastName()).append(",").append(System.lineSeparator()).append(System.lineSeparator());
        buffer.append("Dear ").append(user.getUsername()).append(" ").append(",").append(System.lineSeparator()).append(System.lineSeparator());
        buffer.append("Your account has been successfully created in the Flashcards application. ");

        // buffer.append("Activate your account by clicking the following link: https://valdemar.pl/course/verify/email?id=").append(encodedVerificationId);
        buffer.append("Activate your account by clicking the following link: http://localhost:8080/verify/email?id=").append(encodedVerificationId);
        buffer.append(System.lineSeparator()).append(System.lineSeparator());
    	buffer.append("Regards,").append(System.lineSeparator()).append("Flashcards Team");
    	return buffer.toString();
    }
}
