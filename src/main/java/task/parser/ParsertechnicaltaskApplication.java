package task.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ParsertechnicaltaskApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ParsertechnicaltaskApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.main.banner-mode", "off");
        properties.setProperty("logging.pattern.console", "");
        app.setDefaultProperties(properties);
        app.run(args);
    }
}