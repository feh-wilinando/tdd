package br.com.caelum.cinema.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.cinema.converters.ProviderConverter;
import br.com.caelum.cinema.converters.UserConverter;
import br.com.caelum.cinema.listener.LoginListeners;
import br.com.caelum.cinema.mocks.ExternalAuthenticationListenerMock;
import br.com.caelum.cinema.mocks.LogListenerMock;
import br.com.caelum.cinema.mocks.RequestParamsMock;


public class LoginControllerTest {

	private RequestParamsMock params;
	private LoginController controller;
	private ExternalAuthenticationListenerMock externalAuthentication;
	private LogListenerMock logger;
	
	@Before
	public void setup(){
		params = new RequestParamsMock();
		
		UserConverter userConverter = new UserConverter();
		ProviderConverter providerConverter = new ProviderConverter();
		
		externalAuthentication = new ExternalAuthenticationListenerMock();
		logger = new LogListenerMock();
		
		LoginListeners listeners = new LoginListeners();
		
		listeners.add(logger);
		listeners.add(externalAuthentication);
		
		controller = new LoginController(userConverter, providerConverter, listeners );
	}
	
	@Test
	public void shouldGoesToHomepageAfterSuccessLoginWithEmailProvider(){
		
		//Arrange (Given)
		params.valueFor("email", "validUser@email.com");
		params.valueFor("password", "validPassword");
		params.valueFor("provider", "EMAIL");
		
		//Act (When)
		String page = controller.login(params);
		
		//Assert (Then)
		Assert.assertEquals("redirect:/home", page);
	}
	
	@Test
	public void shouldGoesToHomepageAfterSuccessLoginWithGPlusProvider(){
		
		//Arrange (Given)
		params.valueFor("email", "validUser@email.com");
		params.valueFor("password", "");
		params.valueFor("provider", "GPLUS");
		
		//Act (When)
		String page = controller.login(params);
		
		//Assert (Then)
		Assert.assertEquals("redirect:/home", page);
	}
	
	@Test
	public void shouldGoesToHomepageAfterSuccessLoginWithGitHubProvider(){
		
		//Arrange (Given)
		params.valueFor("email", "validUser@email.com");
		params.valueFor("password", "");
		params.valueFor("provider", "GITHUB");
		
		//Act (When)
		String page = controller.login(params);
		
		//Assert (Then)
		Assert.assertEquals("redirect:/home", page);
	}
	
	
	@Test
	public void shouldGoesToHomepageAfterSuccessLoginWithFacebookProvider(){
		
		//Arrange (Given)
		params.valueFor("email", "validUser@email.com");
		params.valueFor("password", "");
		params.valueFor("provider", "FACEBOOK");
		
		//Act (When)
		String page = controller.login(params);
		
		//Assert (Then)
		Assert.assertEquals("redirect:/home", page);
	}
	
	@Test
	public void shouldStayInLoginpageAfterFailLogin(){
		
		//Arrange (Given)				
		//Act (When)
		String page = controller.login(params);
		
		//Assert (Then)
		Assert.assertEquals("login", page);
	}
	
	
	@Test
	public void shouldCallAllListnerAfterSuccessLogin(){
		//Arrange (Given)
		params.valueFor("email", "validUser@email.com");
		params.valueFor("password", "");
		params.valueFor("provider", "FACEBOOK");
		
		//Act (When)
		controller.login(params);
						
		//Assert 
		Assert.assertTrue(externalAuthentication.performActionWasCalled);
		Assert.assertTrue(logger.performActionWasCalled);
	}
	
	
	@Test
	public void shouldNotCallAllListnerAfterSuccessLogin(){
		//Arrange (Given)
		
		
		//Act (When)
		controller.login(params);
						
		//Assert 
		Assert.assertFalse(externalAuthentication.performActionWasCalled);
		Assert.assertFalse(logger.performActionWasCalled);
	}
	
}
