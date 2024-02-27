package com.educonnect.rithikraj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.educonnect.rithikraj.dto.request.RegisterRequest;
import com.educonnect.rithikraj.service.UserService;

@SpringBootApplication
public class RithikrajApplication {

	public static void main(String[] args) {
		SpringApplication.run(RithikrajApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {
			var user = RegisterRequest.builder().name("Admin").email("admin@gmail.com").password("Admin@123").mobile("9345049320").role("ADMIN").build();
			userService.register(user);
		};
	}

}
