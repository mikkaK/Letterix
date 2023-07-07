package ch.letterix.letterix_backend.domain.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoverLetterService extends AbstractService<CoverLetter> {

    String getCoverLetter(CoverLetter coverLetter);
}
