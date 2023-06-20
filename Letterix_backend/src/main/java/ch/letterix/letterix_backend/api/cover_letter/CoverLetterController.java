package ch.letterix.letterix_backend.api.cover_letter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cover_letter")
public class CoverLetterController {
    private final CoverLetterService coverLetterService;
    private final CoverLetterRepository coverLetterRepository;
    public CoverLetterController(CoverLetterService coverLetterService, CoverLetterRepository coverLetterRepository) {
        this.coverLetterService = coverLetterService;
        this.coverLetterRepository = coverLetterRepository;
    }

    @PostMapping("/")
    public ResponseEntity<String> registerWithoutPassword(@RequestBody CoverLetter coverLetter) {
        return new ResponseEntity<>(coverLetterService.getCoverLetter(coverLetter), HttpStatus.CREATED);
    }
}
