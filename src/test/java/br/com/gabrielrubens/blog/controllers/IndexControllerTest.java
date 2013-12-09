package br.com.gabrielrubens.blog.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.gabrielrubens.blog.repositories.PostRepositoryImpl;

public class IndexControllerTest {
	@Mock
	private PostRepositoryImpl postRepository;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveRetornarOsUltimosPosts() {
		IndexController controller = new IndexController(postRepository);
		controller.index();
		Mockito.verify(postRepository, Mockito.times(1)).ultimos();
		
	}
}
