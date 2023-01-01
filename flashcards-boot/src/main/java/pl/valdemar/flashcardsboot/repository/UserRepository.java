package pl.valdemar.flashcardsboot.repository;

import org.springframework.data.repository.CrudRepository;
import pl.valdemar.flashcardsboot.model.ApplicationUser;

public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}
