package ch.letterix.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CoverLetterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoverLetterApplication.class, args);
    }

}
