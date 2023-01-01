package pl.valdemar.flashcardsboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardsBootApplication {

    private static Logger logger = LoggerFactory.getLogger(FlashcardsBootApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(FlashcardsBootApplication.class, args);
        logger.info("FlashcardsBootApplication started successfully with Log4j2 configuration");
    }

}
