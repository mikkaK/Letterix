package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.Entities.PromptObject;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RequestHandler implements RequestHandlerInterface{
    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${openai.OPENAI_API_KEY}")
    private String apiKey;

    @Override
    public String handleApplicationRequest(PromptObject promptObject) {

        String prompt = buildPrompt(promptObject);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String requestJson = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\""+ prompt +"\"}]}";

        HttpEntity<?> request = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, request, String.class);

            return response.getBody();
    }

    public String buildPrompt(PromptObject promptObject){
        return "Erstelle ein Bewerbungsschreiben für einen " +
                promptObject.getAge()+
                "jährigen Schweizer " +
                promptObject.getCurrentEducationLevel() +
                ", der sich um eine Lehrstelle als " +
                promptObject.getPosition() +
                " bei " +
                promptObject.getAppliedCompany() +
                " bewirbt. Benutze diese Informationen des Schülers, um das Schreiben zu personalisieren:" +
                " Name:" +
                promptObject.getName() + promptObject.getSurname() +
                ", Alter:" +
                promptObject.getAge() +
                ", Hobbys:" +
                promptObject.getInterests() +
                ", Stärken:" +
                promptObject.getSkills() +
                ", Schwächen:" +
                promptObject.getWeaknesses() +
                ". Recherchiere über das angegebene Unternehmen (" +
                promptObject.getAppliedCompany() +
                ") und füge Details über" +
                promptObject.getAppliedCompany() +
                "in den Brief ein, damit er auf " +
                promptObject.getAppliedCompany() +
                "zugeschnitten ist. Verwende die nachfolgenden Styleregeln und Grammatik Anweisungen: Ersetze alle Schwächen durch weniger negativ klingende Synonyme; Der Brief sollte nicht perfekt sein und kann sogar einen Fehler enthalten; Da der Brief von einem jungen Menschen geschrieben wird, sollte er keine komplexe oder schwierige Wörter enthalten; Es darf nie 3 mal hintereinander der gleiche Satzanfang verwendet werden; Verwende keine ß.";

    }
}
