package ch.letterix.letterix_backend.api.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractService;

public interface CoverLetterService extends AbstractService<CoverLetter> {

    String getCoverLetter(CoverLetter coverLetter);
}
