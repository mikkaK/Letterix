package ch.letterix.letterix_backend.domain.user;

import ch.letterix.letterix_backend.core.generic.AbstractEntity;
import ch.letterix.letterix_backend.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter@Setter
@Table(name = "users")
public class User extends AbstractEntity {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(UUID id, String firstName, String lastName, String email, String password, Set<Role> roles) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

}
