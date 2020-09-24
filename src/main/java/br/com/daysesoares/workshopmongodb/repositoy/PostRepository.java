package br.com.daysesoares.workshopmongodb.repositoy;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.daysesoares.workshopmongodb.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{

	List<Post> findByTitleContaining(String text);
	
}
