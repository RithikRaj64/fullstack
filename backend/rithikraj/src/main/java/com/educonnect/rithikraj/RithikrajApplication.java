package com.educonnect.rithikraj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.service.AuthenticationService;

@SpringBootApplication
@RequiredArgsConstructor
public class RithikrajApplication {

	@SuppressWarnings("unused")
	private final AuthenticationService authenticationService;

	public static void main(String[] args) {
		SpringApplication.run(RithikrajApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService authenticationService) {
		return args -> {
			var user = RegisterRequest.builder().name("Admin").email("admin@gmail.com").password("Admin@123").mobile("9345049320").role("ADMIN").build();
			authenticationService.register(user);
		};
	}

}
