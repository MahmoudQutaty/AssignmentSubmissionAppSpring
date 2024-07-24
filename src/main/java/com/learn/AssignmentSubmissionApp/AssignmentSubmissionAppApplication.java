package com.learn.AssignmentSubmissionApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import java.util.Arrays;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class AssignmentSubmissionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentSubmissionAppApplication.class, args);
	}
}
