package ch.letterix.letterix_backend.api.cover_letter;

import ch.letterix.letterix_backend.core.generic.AbstractRepository;
import ch.letterix.letterix_backend.core.generic.AbstractServiceImpl;
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

@Service
@Log4j2
public class CoverLetterServiceImpl extends AbstractServiceImpl<CoverLetter> implements CoverLetterService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${letterix.COVER_LETTER_API_URL}")
    private String COVER_LETTER_API_URL;
    ObjectMapper mapper = new ObjectMapper();
    protected CoverLetterServiceImpl(AbstractRepository<CoverLetter> repository) {
        super(repository);
    }

    @Override
    public String getCoverLetter(CoverLetter coverLetter) {

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

        /*String requestJson = "{\"name\":\"" +
                coverLetter.getName() +
                "\"" +
                ",\"surname\":\"" +
                coverLetter.getSurname() +
                "\"" +
                ",\"age\":\"" +
                coverLetter.getAge() +
                "\""+
                ",\"appliedCompany\":\"" +
                coverLetter.getAppliedCompany() +
                "\"" +
                ",\"position\":\"" +
                coverLetter.getPosition() +
                "\"" +
                ",\"currentEducation\":\"" +
                coverLetter.getCurrentEducationLevel() +
                "\"" +
                ",\"skills\":[\"" +
                coverLetter.getSkills() +
                "\"]" +
                ",\"interests\":[\"" +
                coverLetter.getInterests() +
                "\"]" +
                ",\"weaknesses\":[\"" +
                coverLetter.getWeaknesses() +
                "\"]}"; */

        HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        log.info("Request: " + requestBody);

        ResponseEntity<String> response = restTemplate.postForEntity(COVER_LETTER_API_URL, request, String.class);
        return response.toString();
    }
}
