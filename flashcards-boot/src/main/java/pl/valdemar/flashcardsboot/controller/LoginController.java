package pl.valdemar.flashcardsboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.valdemar.flashcardsboot.util.Mappings;
import pl.valdemar.flashcardsboot.util.ViewNames;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    // == model attributes ==
    @ModelAttribute(name = "paths")
    public Map<String, String> appPaths() {
        Map<String, String> paths = new HashMap<>();
        paths.put("index", Mappings.INDEX);
        paths.put("login", Mappings.LOGIN);
        paths.put("add-user", Mappings.ADD_USER);
        return paths;
    }

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
