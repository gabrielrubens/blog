package br.com.gabrielrubens.blog.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;


public abstract class Repository<T, I extends Serializable> {
	protected Session session;
	protected Class<T> clazz;

	@Deprecated
	public Repository(){
	}
	
	@Inject
	protected Repository(Session session) {
		this.session = session;

		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazz = clazz;
	}

	public void criar(T entity){
		session.persist(entity);
	}
	
	public List<T> findAll() {
		Query query = session.createQuery("from " + clazz.getName());

		@SuppressWarnings("unchecked")
		List<T> resultList = query.list();

		return resultList;
	}
}
