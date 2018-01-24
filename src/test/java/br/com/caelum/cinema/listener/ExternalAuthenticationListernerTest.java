package br.com.caelum.cinema.listener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caelum.cinema.mocks.ExternalAuthenticationListenerMock;
import br.com.caelum.cinema.models.User;

public class ExternalAuthenticationListernerTest {

	@Rule
	public final ExpectedException expected = ExpectedException.none();
	
	private ExternalAuthenticationListenerMock externalAuthentication;

	@Before
	public void setup(){
		externalAuthentication = new ExternalAuthenticationListenerMock();
	}
	
	@Test
	public void shouldBeAbleAuthenticateForExternalSystemWithValidUser(){
		//Arrange
		User user = new User("valid@email.com", "123");
		
		//Act
		externalAuthentication.performAction(user);
		
		//Assert
		Assert.assertTrue(externalAuthentication.performActionWasCalled);
	}
	
	@Test
	public void shouldNotBeAbleAuthenticateForExternalSystemWhenUserIsNull(){
		
		//Assert
		expected.expect(NullPointerException.class);
		expected.expectMessage("User is required.");
		
		
		//Arrange 
		User user = null;		
		
		//Act
		externalAuthentication.performAction(user);
		
		Assert.assertFalse(externalAuthentication.performActionWasCalled);
		
	}
	
	
}
