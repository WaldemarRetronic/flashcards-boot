package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.dto.EmailDto;
import pl.valdemar.flashcardsboot.dto.PasswordDto;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.service.DeckService;
import pl.valdemar.flashcardsboot.service.FlashcardService;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class AccountController {

    // == fields ==
    private final UserService userService;
    private final DeckService deckService;
    private final FlashcardService flashcardService;
    private final PasswordEncoder encoder;

    public AccountController(UserService userService, DeckService deckService, FlashcardService flashcardService, PasswordEncoder encoder) {
        this.userService = userService;
        this.deckService = deckService;
        this.flashcardService = flashcardService;
        this.encoder = encoder;
    }

    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        DeckController.PathMapping(paths);
        paths.put("account-password", Mappings.ACCOUNT_SETTINGS_PASSWORD);
        paths.put("account-email", Mappings.ACCOUNT_SETTINGS_EMAIL);
        paths.put("account-remove", Mappings.REMOVE_ACCOUNT);
        return paths;
    }

    // == handler methods ==

    @GetMapping(Mappings.ACCOUNT_SETTINGS)
    public String changeSettings(Model model, Principal principal) {
        model.addAttribute("password", new PasswordDto());
        model.addAttribute("email", new EmailDto());
        model.addAttribute("username", principal.getName());
        return ViewNames.ACCOUNT;
    }

    @PutMapping(Mappings.ACCOUNT_SETTINGS_PASSWORD)
    public String changePassword(@RequestParam("mode") String mode, @Valid @ModelAttribute("password") PasswordDto passwordDto,
                                 BindingResult result, Principal principal, Model model, HttpServletRequest request) throws ServletException {
        if (result.hasErrors()) {
            model.addAttribute("email", new EmailDto());
            model.addAttribute("username", principal.getName());
            return ViewNames.ACCOUNT;
        }
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());
        if (!encoder.matches(passwordDto.getCurrentPassword(), applicationUser.getPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?password_error";
        }
        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?passwords_mismatch";
        }
        applicationUser.setPassword(encoder.encode(passwordDto.getNewPassword()));
        userService.save(applicationUser);
        request.logout();
        return "redirect:" + Mappings.LOGIN;
    }

    @PutMapping(Mappings.ACCOUNT_SETTINGS_EMAIL)
    public String changeEmail(@RequestParam("mode") String mode, @Valid @ModelAttribute("email") EmailDto emailDto,
                              BindingResult result, Principal principal, Model model, HttpServletRequest request) throws ServletException {
        if (result.hasErrors()) {
            model.addAttribute("password", new PasswordDto());
            model.addAttribute("username", principal.getName());
            return ViewNames.ACCOUNT;
        }
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());

        if (!encoder.matches(emailDto.getCurrentPassword(),applicationUser.getPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?password_error";
        }
        if (!emailDto.getNewEmail().equals(emailDto.getConfirmEmail())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?emails_mismatch";
        }
        if (userService.exist(emailDto.getNewEmail())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?already_exists";
        }

        applicationUser.setUsername(emailDto.getNewEmail());
        userService.save(applicationUser);
        request.logout();
        return "redirect:" + Mappings.LOGIN;
    }

    @GetMapping(Mappings.REMOVE_ACCOUNT)
    public String removeAccount(Principal principal, Model model) {
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());
        if (applicationUser.getPassword() == null) {
            model.addAttribute("google_account", true);
        }
        return ViewNames.REMOVE_ACCOUNT;
    }

    @ResponseBody
    @PostMapping(Mappings.REMOVE_ACCOUNT)
    public String removeAccount(@RequestParam("pass") String password, Principal principal, HttpServletRequest request) throws ServletException {
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());
        String pass = applicationUser.getPassword();
        if (pass == null || encoder.matches(password, pass)) {
            Long userId = applicationUser.getId();
            flashcardService.deleteAll(userId);
            deckService.deleteAll(userId);
            userService.delete(applicationUser);
            request.logout();
            return "Your account has been successfully removed.";
        } else {
            return "Sorry, your password did not match our records. Please click back and try again.";
        }
    }

}
