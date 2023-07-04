package ch.letterix.letterix_backend.domain.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractService;

public interface CoverLetterService extends AbstractService<CoverLetter> {

    String getCoverLetter(CoverLetter coverLetter);
}
