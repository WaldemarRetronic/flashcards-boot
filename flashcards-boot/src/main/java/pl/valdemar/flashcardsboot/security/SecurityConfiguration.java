package pl.valdemar.flashcardsboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.valdemar.flashcardsboot.handler.CustomAuthenticationFailureHandler;
import pl.valdemar.flashcardsboot.repository.UserRepository;
import pl.valdemar.flashcardsboot.service.UserService;
import pl.valdemar.flashcardsboot.service.impl.Oauth2AuthenticationSuccessHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
        http.requiresChannel().anyRequest().requiresSecure()
                .and()
                .authorizeRequests()
                .antMatchers("/adduser", "/login", "/login-error", "/login-verified", "/login-disabled",
                        "/verify/email")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").failureHandler(customAuthenticationFailureHandler)
                .and()
                .oauth2Login().loginPage("/login").successHandler(oauth2AuthenticationSuccessHandler());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/webjars/**", "/images/*", "/css/*", "/h2-console/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public Oauth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler() {
        return new Oauth2AuthenticationSuccessHandler();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
//        return map -> {
//            String principalId = (String) map.get("id");
//            User user = userRepository.findByPrincipalId(principalId);
//            if (user == null) {
//                LOGGER.info("No user found, generating profile for {}", principalId);
//                user = new User();
//                user.setPrincipalId(principalId);
//                user.setCreated(LocalDateTime.now());
//                user.setEmail((String) map.get("email"));
//                user.setFullName((String) map.get("name"));
//                user.setPhoto((String) map.get("picture"));
//                user.setLoginType(UserLoginType.GOOGLE);
//                user.setLastLogin(LocalDateTime.now());
//            } else {
//            }
//            userRepository.save(user);
//            return user;
//        };
//    }

}
