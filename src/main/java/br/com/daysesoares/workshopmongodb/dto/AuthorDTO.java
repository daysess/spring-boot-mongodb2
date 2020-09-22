package br.com.daysesoares.workshopmongodb.dto;

import br.com.daysesoares.workshopmongodb.domain.User;
import lombok.Data;

@Data
public class AuthorDTO {
		
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}
	
}
