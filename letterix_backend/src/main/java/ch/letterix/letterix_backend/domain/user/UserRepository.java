package ch.letterix.letterix_backend.domain.user;

import ch.letterix.letterix_backend.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByEmail(String email);
}
