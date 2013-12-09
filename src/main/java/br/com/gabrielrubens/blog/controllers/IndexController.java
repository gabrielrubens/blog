package br.com.gabrielrubens.blog.controllers;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.gabrielrubens.blog.models.Post;
import br.com.gabrielrubens.blog.repositories.PostRepository;
import br.com.gabrielrubens.blog.repositories.PostRepositoryImpl;

@Controller
public class IndexController {

	@Inject
	private PostRepository repository;

	public IndexController(PostRepositoryImpl repository) {
		this.repository = repository;
	}

	@Path("/")
	public List<Post> index() {
		return repository.ultimos();
	}
}