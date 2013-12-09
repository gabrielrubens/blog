package br.com.gabrielrubens.blog.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.gabrielrubens.blog.models.Post;

public class PostRepositoryImpl extends Repository<Post, Long> implements PostRepository {
	
	protected PostRepositoryImpl(Session session) {
		super(session);
	}

	public List<Post> ultimos() {
		Query query = session.createQuery("from " + Post.class.getName());

		@SuppressWarnings("unchecked")
		List<Post> resultList = query.list();
		return resultList;
	}
}
