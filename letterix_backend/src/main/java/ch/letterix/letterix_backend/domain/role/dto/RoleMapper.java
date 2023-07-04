package ch.letterix.letterix_backend.domain.role.dto;

import ch.letterix.letterix_backend.core.generic.AbstractMapper;
import ch.letterix.letterix_backend.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends AbstractMapper<Role, RoleDTO> {
}
