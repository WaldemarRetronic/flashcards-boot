package pl.valdemar.flashcardsboot.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.dto.UserDto;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.repository.UserRepository;
import pl.valdemar.flashcardsboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApplicationUser createUser(UserDto userDto) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(userDto.getUsername());
        applicationUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser save(ApplicationUser applicationUser) {
        return userRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(ApplicationUser applicationUser) {
        userRepository.delete(applicationUser);
    }

    @Override
    public boolean exist(String username) {
        return userRepository.existsByUsername(username);
    }
}
