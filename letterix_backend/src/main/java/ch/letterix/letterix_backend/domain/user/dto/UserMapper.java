package ch.letterix.letterix_backend.domain.user.dto;


import ch.letterix.letterix_backend.core.generic.AbstractMapper;
import ch.letterix.letterix_backend.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
  User fromUserRegisterDTO(UserRegisterDTO dto);
}
