package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("emerson@gmail.com");
		emerson.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza");
		luiza.setEmail("luiza@gmail.com");
		luiza.setGender("F");
		
		User renaki = new User();
		renaki.setName("Renaki");
		renaki.setEmail("renaki@gmail.com");
		renaki.setGender("M");
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		userRepository.save(renaki);
     }
	
}
