package br.com.daysesoares.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysesoares.workshopmongodb.domain.User;
import br.com.daysesoares.workshopmongodb.repositoy.UserRepository;
import br.com.daysesoares.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado.");
		}
		return user.get();
	}

}
