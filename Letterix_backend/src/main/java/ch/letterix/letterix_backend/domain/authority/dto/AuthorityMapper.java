package ch.letterix.letterix_backend.domain.authority.dto;

import ch.letterix.letterix_backend.core.generic.AbstractMapper;
import ch.letterix.letterix_backend.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends AbstractMapper<Authority, AuthorityDTO> {
}

