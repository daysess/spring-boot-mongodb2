package br.com.daysesoares.workshopmongodb.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO {

	private String text;
	private Date date;
	private AuthorDTO author;
}
