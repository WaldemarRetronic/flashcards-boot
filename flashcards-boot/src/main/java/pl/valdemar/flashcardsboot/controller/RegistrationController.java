package pl.valdemar.flashcardsboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.valdemar.flashcardsboot.FlashcardsBootApplication;
import pl.valdemar.flashcardsboot.dto.UserDto;
import pl.valdemar.flashcardsboot.event.UserRegistrationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        logger.info("model: {}", model);
        return "add-user";
    }

    @PostMapping("/adduser")
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {
        if(result.hasErrors()) {
            return "add-user";
        }
        logger.info("called adduser POST");
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            logger.info("password equals");
            return "redirect:adduser?error";
        }
        if(userService.findByUsername(userDto.getUsername()) != null) {
            if (userService.findByUsername(userDto.getUsername()).isVerified()) {
                return "redirect:adduser?success";
            } else {
                return "redirect:adduser?validate";
            }

        }
        ApplicationUser applicationUser = userService.createUser(userDto);
        logger.info(String.valueOf(applicationUser));
        eventPublisher.publishEvent(new UserRegistrationEvent(applicationUser));
        return "redirect:adduser?validate";
    }

    @GetMapping("/adduser-password-error")
    public String registerPasswordError(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("passwordError", true);
        return "add-user";
    }

    @GetMapping("/adduser-username-error")
    public String registerUsernameError(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("usernameError", true);
        return "add-user";
    }


}
