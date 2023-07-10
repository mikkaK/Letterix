package ch.letterix.letterix_backend.domain.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractRepository;
import ch.letterix.letterix_backend.core.generic.AbstractServiceImpl;
import ch.letterix.letterix_backend.domain.storage_object.StorageObject;
import ch.letterix.letterix_backend.domain.storage_object.StorageObjectService;
import ch.letterix.letterix_backend.entities.response.ChatCompletition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.UUID;

@Service
@Log4j2
public class CoverLetterServiceImpl extends AbstractServiceImpl<CoverLetter> implements CoverLetterService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${letterix.COVER_LETTER_API_URL}")
    private String COVER_LETTER_API_URL;
    private final CoverLetterRepository coverLetterRepository;
    private final StorageObjectService storageObjectService;
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    protected CoverLetterServiceImpl(AbstractRepository<CoverLetter> repository, CoverLetterRepository coverLetterRepository, StorageObjectService storageObjectService) {
        super(repository);
        this.coverLetterRepository = coverLetterRepository;
        this.storageObjectService = storageObjectService;
    }

    @Override
    public String getCoverLetter(CoverLetter coverLetter)  {

        CoverLetter SavedCoverLetter = saveCoverLetter(coverLetter);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String requestBody = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            requestBody = objectMapper.writeValueAsString(coverLetter);
        }catch (Exception e){
            log.error("Error while parsing cover letter object to JSON");
        }

        HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        log.info("Request: " + requestBody);

        ResponseEntity<String> response = restTemplate.postForEntity(COVER_LETTER_API_URL, request, String.class);
        try {
            log.info("Response: " + response.getBody());
            ChatCompletition completition = mapper.readValue(response.getBody(), ChatCompletition.class);
            saveStorageObject(completition, SavedCoverLetter);
        }catch (Exception e){
            log.error("Error while parsing response body to ChatCompletition object" + e.getMessage());
        }

        return response.toString();

    }

    public CoverLetter saveCoverLetter (CoverLetter coverLetter){
       return coverLetterRepository.save(coverLetter);
    }

    public StorageObject saveStorageObject (ChatCompletition completition, CoverLetter coverLetter){
        return storageObjectService.save(new StorageObject(UUID.randomUUID(), coverLetter, completition));
    }
}
