package com.felipeteles.filterTest.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipeteles.filterTest.domain.Log;
import com.felipeteles.filterTest.domain.User;
import com.felipeteles.filterTest.repository.LogRepository;
import com.felipeteles.filterTest.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LogRepository logRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		logRepository.deleteAll();
		
		User user1 = new User(null, "João Augusto", 32);
		User user2 = new User(null, "Felipe Teles de Medeiros", 23);
		User user3 = new User(null, "Rafael Barros", 12);
		
		LocalDate date = LocalDate.now();
		
		Log log = new Log(null, "Teste", "Teste", date+"");
		Log log2 = new Log(null, "Teste", "Teste", date+"");
		
		logRepository.saveAll(Arrays.asList(log, log2));
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}