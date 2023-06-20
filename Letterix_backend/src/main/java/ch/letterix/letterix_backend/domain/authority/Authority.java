package ch.letterix.letterix_backend.domain.authority;

import ch.letterix.letterix_backend.core.generic.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "authority")
public class Authority extends AbstractEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  public Authority() {
  }

  public Authority(UUID id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Authority setName(String name) {
    this.name = name;
    return this;
  }
}
