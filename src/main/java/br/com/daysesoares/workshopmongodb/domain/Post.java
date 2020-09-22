package br.com.daysesoares.workshopmongodb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.daysesoares.workshopmongodb.dto.AuthorDTO;
import br.com.daysesoares.workshopmongodb.dto.CommentDTO;
import lombok.Data;


@Document("post")
@Data
public class Post{
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	
	public Post() {		
	}

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
}
