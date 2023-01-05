package pl.valdemar.flashcardsboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.repository.UserRepository;
import pl.valdemar.flashcardsboot.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class Oauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	redirectStrategy.sendRedirect(request, response, "/index");
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        Stream<Map.Entry<String, Object>> attributes = user.getAttributes().entrySet().stream();
        attributes
                .forEach(e -> log.info("{} --- {}", e.getKey(), e.getValue()));

        String username = user.getAttribute("sub");
        if (userService.findByUsername(username) == null) {
            ApplicationUser applicationUser = new ApplicationUser(username);
            applicationUser.setVerified(true);
            userService.save(applicationUser);
        }
 }
}
