package pl.valdemar.flashcardsboot.service;


import pl.valdemar.flashcardsboot.dto.UserDto;
import pl.valdemar.flashcardsboot.model.ApplicationUser;

public interface UserService {

    ApplicationUser createUser(UserDto userDto);
    ApplicationUser save(ApplicationUser applicationUser);
    ApplicationUser findByUsername(String username);

}
