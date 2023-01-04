package pl.valdemar.flashcardsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.service.EmailVerificationService;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.Mappings;

import java.util.Base64;

@Controller
public class EmailVerificationController {

    @Autowired
    private EmailVerificationService verificationService;

    @Autowired
    private UserService userService;

    @GetMapping(Mappings.VERIFY_EMAIL)
    public String verifyEmail(@RequestParam String id) {
    	byte[] actualId = Base64.getDecoder().decode(id.getBytes());
        String username = verificationService.getUsernameForVerificationId(new String(actualId));
        if(username != null) {
            ApplicationUser user = userService.findByUsername(username);
            user.setVerified(true);
            userService.save(user);
            return "redirect:" + Mappings.LOGIN_VERIFIED;
        }
        return "redirect:" + Mappings.LOGIN_ERROR;
    }
}
