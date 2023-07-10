package ch.letterix.letterix_backend.domain.authority.dto;

import ch.letterix.letterix_backend.core.generic.AbstractDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class AuthorityDTO extends AbstractDTO {

  @NotNull
  @Size(min = 1, max = 255)
  private String name;

  public AuthorityDTO() {
  }

  public AuthorityDTO(UUID id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public AuthorityDTO setName(String name) {
    this.name = name;
    return this;
  }

}
