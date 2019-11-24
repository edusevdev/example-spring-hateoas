package edu.example.hateoas.examplehateoas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleHateoasApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleHateoasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExampleHateoasApplication.class, args);
		logConnectionH2();
	}

	private static void logConnectionH2() {
		LOGGER.info("##################################################");
		LOGGER.info("################## H2 CONNECTION #################");
		LOGGER.info("##################################################");
		LOGGER.info("## H2 CONSOLE: http://localhost:8080/h2-console ##");
		LOGGER.info("## JDBC URL: jdbc:h2:mem:testdb                 ##");
		LOGGER.info("##################################################");
	}

}
