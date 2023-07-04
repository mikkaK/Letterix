package ch.letterix.letterix_backend.domain.role;


import ch.letterix.letterix_backend.core.generic.AbstractEntity;
import ch.letterix.letterix_backend.domain.authority.Authority;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
  private Set<Authority> authorities = new HashSet<>();

  public Role() {
  }

  public Role(UUID id, String name, Set<Authority> authorities) {
    super(id);
    this.name = name;
    this.authorities = authorities;
  }

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
    return this;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public Role setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }
}