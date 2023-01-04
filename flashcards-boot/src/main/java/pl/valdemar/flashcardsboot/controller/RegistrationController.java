package pl.valdemar.flashcardsboot.controller;

import lombok.extern.slf4j.Slf4j;
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
import pl.valdemar.flashcardsboot.dto.UserDto;
import pl.valdemar.flashcardsboot.event.UserRegistrationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import javax.validation.Valid;

@Slf4j
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping(Mappings.ADD_USER)
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        log.info("model: {}", model);
        return "add-user";
    }

    @PostMapping(Mappings.ADD_USER)
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            return ViewNames.ADD_USER;
        }
        log.info("called adduser POST");
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            log.info("password equals");
            return "redirect:" + Mappings.ADD_USER + "?error";
        }
        if (userService.findByUsername(userDto.getUsername()) != null) {
            if (userService.findByUsername(userDto.getUsername()).isVerified()) {
                return "redirect:" + Mappings.ADD_USER + "?success";
            } else {
                return "redirect:" + Mappings.ADD_USER + "?validate";
            }

        }
        ApplicationUser applicationUser = userService.createUser(userDto);
        log.info(String.valueOf(applicationUser));
        eventPublisher.publishEvent(new UserRegistrationEvent(applicationUser));
        return "redirect:" + Mappings.ADD_USER + "?validate";
    }

}
