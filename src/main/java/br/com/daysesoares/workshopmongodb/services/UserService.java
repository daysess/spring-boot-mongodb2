package br.com.daysesoares.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysesoares.workshopmongodb.domain.User;
import br.com.daysesoares.workshopmongodb.repositoy.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

}
