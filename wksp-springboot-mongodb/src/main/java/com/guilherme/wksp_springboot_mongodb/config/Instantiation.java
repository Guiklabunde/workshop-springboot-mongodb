package com.guilherme.wksp_springboot_mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.wksp_springboot_mongodb.domain.User;
import com.guilherme.wksp_springboot_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "maria@gmail.com");
		User guilherme = new User(null, "Guilherme Andrei", "guiandrei17@gmail.com");
		User senna = new User(null, "Ayrton", "dobrasil@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, guilherme, senna));
		
	}
	
}
