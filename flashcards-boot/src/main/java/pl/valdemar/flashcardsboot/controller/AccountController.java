package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.valdemar.flashcardsboot.dto.DeckDto;
import pl.valdemar.flashcardsboot.dto.EmailDto;
import pl.valdemar.flashcardsboot.dto.PasswordDto;
import pl.valdemar.flashcardsboot.dto.UserDto;
import pl.valdemar.flashcardsboot.event.UserRegistrationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
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

    @Autowired
    private UserService userService;

    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("index", Mappings.INDEX);
        paths.put("add-deck", Mappings.ADD_DECK);
        paths.put("logout", Mappings.LOGOUT);
        paths.put("flashcards", Mappings.SHOW_FLASHCARDS);
        paths.put("search", Mappings.SEARCH);
        paths.put("study", Mappings.STUDY_SESSION);
        paths.put("account", Mappings.ACCOUNT_SETTINGS);
        paths.put("account-password", Mappings.ACCOUNT_SETTINGS_PASSWORD);
        paths.put("account-email", Mappings.ACCOUNT_SETTINGS_EMAIL);
        return paths;
    }

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
            log.info("password errors");
            return ViewNames.ACCOUNT;
        }
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());
        if (!passwordDto.getCurrentPassword().equals(applicationUser.getPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?password_error";
        }
        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?passwords_mismatch";
        }
        applicationUser.setPassword(passwordDto.getNewPassword());
        userService.save(applicationUser);
        log.info("called changeSettings with mode: {}", mode);
        log.info("new pass: {}", passwordDto.getNewPassword());
        log.info("confirm pass: {}", passwordDto.getConfirmPassword());
        log.info("current pass: {}", passwordDto.getCurrentPassword());
        request.logout();
        return "redirect:" + Mappings.LOGIN;
    }

    @PutMapping(Mappings.ACCOUNT_SETTINGS_EMAIL)
    public String changeEmail(@RequestParam("mode") String mode, @Valid @ModelAttribute("email") EmailDto emailDto,
                              BindingResult result, Principal principal, Model model, HttpServletRequest request) throws ServletException {
        if (result.hasErrors()) {
            model.addAttribute("password", new PasswordDto());
            log.info("email errors");
            return ViewNames.ACCOUNT;
        }
        ApplicationUser applicationUser = userService.findByUsername(principal.getName());

        if (!emailDto.getCurrentPassword().equals(applicationUser.getPassword())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?password_error";
        }
        if (!emailDto.getNewEmail().equals(emailDto.getConfirmEmail())) {
            return "redirect:" + Mappings.ACCOUNT_SETTINGS + "?emails_mismatch";
        }
        applicationUser.setUsername(emailDto.getNewEmail());
        userService.save(applicationUser);
        log.info("called changeSettings with mode: {}", mode);
        log.info("new email: {}", emailDto.getNewEmail());
        log.info("confirm email: {}", emailDto.getConfirmEmail());
        log.info("current pass: {}", emailDto.getCurrentPassword());
        request.logout();
        return "redirect:" + Mappings.LOGIN;
    }

    private Long getUserId(Principal principal) {
        return userService.findByUsername(principal.getName()).getId();
    }
}
