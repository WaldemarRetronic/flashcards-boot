package pl.valdemar.flashcardsboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

@Controller
public class LoginController {

    @GetMapping(Mappings.LOGIN)
    public String login() {
        return ViewNames.LOGIN;
    }

    @GetMapping(Mappings.LOGIN_ERROR)
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return ViewNames.LOGIN;
    }

    @GetMapping(Mappings.LOGIN_VERIFIED)
    public String loginVerified(Model model) {
        model.addAttribute("loginVerified", true);
        return ViewNames.LOGIN;
    }

    @GetMapping(Mappings.LOGIN_DISABLED)
    public String loginDisabled(Model model) {
        model.addAttribute("loginDisabled", true);
        return ViewNames.LOGIN;
    }
}
