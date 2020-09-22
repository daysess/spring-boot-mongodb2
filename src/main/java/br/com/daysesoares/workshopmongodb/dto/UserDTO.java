package br.com.daysesoares.workshopmongodb.dto;

import br.com.daysesoares.workshopmongodb.domain.User;
import lombok.Data;

@Data
public class UserDTO {
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
		
}
