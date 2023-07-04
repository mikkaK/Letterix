package ch.letterix.letterix_backend.core.security.permissionevaluators;

import ch.letterix.letterix_backend.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionEvaluator {

  public UserPermissionEvaluator() {
  }

  public boolean isUserAboveAge(User principal, int age) {
    return true;
  }

}
