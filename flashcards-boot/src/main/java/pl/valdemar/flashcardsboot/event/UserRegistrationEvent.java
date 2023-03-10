package pl.valdemar.flashcardsboot.event;

import org.springframework.context.ApplicationEvent;
import pl.valdemar.flashcardsboot.model.ApplicationUser;

public class UserRegistrationEvent extends ApplicationEvent {

    private static final long serialVersionUID = -2685172945219633123L;

    private ApplicationUser applicationUser;

    public UserRegistrationEvent(ApplicationUser applicationUser) {
        super(applicationUser);
        this.applicationUser = applicationUser;
    }

    public ApplicationUser getUser() {
        return applicationUser;
    }
}
