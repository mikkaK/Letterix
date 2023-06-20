package ch.letterix.letterix_backend.domain.user;

import ch.letterix.letterix_backend.core.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, AbstractService<User> {
  User register(User user);

  User registerUser(User user);
}
