package br.com.daysesoares.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.daysesoares.workshopmongodb.domain.Post;
import br.com.daysesoares.workshopmongodb.domain.User;
import br.com.daysesoares.workshopmongodb.dto.AuthorDTO;
import br.com.daysesoares.workshopmongodb.dto.CommentDTO;
import br.com.daysesoares.workshopmongodb.repositoy.PostRepository;
import br.com.daysesoares.workshopmongodb.repositoy.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
				
		CommentDTO c1 = new CommentDTO();
		c1.setText("Boa viagem mano!");
		c1.setDate(sdf.parse("21/03/2018"));
		c1.setAuthor(new AuthorDTO(alex));
		
		CommentDTO c2 = new CommentDTO();
		c2.setText("Aproveite");
		c2.setDate(sdf.parse("22/03/2018"));
		c2.setAuthor(new AuthorDTO(bob));
		
		CommentDTO c3 = new CommentDTO();
		c3.setText("Tenha um ótimo dia");
		c3.setDate(sdf.parse("23/03/2018"));
		c3.setAuthor(new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}
	
	

}
