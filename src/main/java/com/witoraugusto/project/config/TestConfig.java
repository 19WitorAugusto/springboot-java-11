package com.witoraugusto.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.witoraugusto.project.entities.User;
import com.witoraugusto.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
				
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "maria Bronw","maria@gmail.com","123456789","142536");
		User u2 = new User(null, "Alex Green","alex@gmail.com","987654321","362514");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
