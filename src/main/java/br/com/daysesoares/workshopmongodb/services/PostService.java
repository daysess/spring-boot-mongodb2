package br.com.daysesoares.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysesoares.workshopmongodb.domain.Post;
import br.com.daysesoares.workshopmongodb.repositoy.PostRepository;
import br.com.daysesoares.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Post não encontrado.");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
}
