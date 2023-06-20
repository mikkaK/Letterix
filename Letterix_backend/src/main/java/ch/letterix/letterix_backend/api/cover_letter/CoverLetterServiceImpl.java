package ch.letterix.letterix_backend.api.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractRepository;
import ch.letterix.letterix_backend.core.generic.AbstractServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class CoverLetterServiceImpl extends AbstractServiceImpl<CoverLetter> implements CoverLetterService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${letterix.COVER_LETTER_API_URL}")
    private static String COVER_LETTER_API_URL;
    ObjectMapper mapper = new ObjectMapper();
    protected CoverLetterServiceImpl(AbstractRepository<CoverLetter> repository) {
        super(repository);
    }

    @Override
    public String getCoverLetter(CoverLetter coverLetter) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String requestJson = "";
        try {
            requestJson = mapper.writeValueAsString(coverLetter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpEntity<?> request = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(COVER_LETTER_API_URL, request, String.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
