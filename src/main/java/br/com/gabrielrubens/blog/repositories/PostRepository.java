package br.com.gabrielrubens.blog.repositories;

import java.util.List;

import br.com.gabrielrubens.blog.models.Post;

public interface PostRepository{
	List<Post> ultimos();
}
