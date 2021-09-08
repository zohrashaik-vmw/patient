package com.livewell.patient;

import com.livewell.patient.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PatientApplication {
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

}
