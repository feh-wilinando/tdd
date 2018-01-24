package br.com.caelum.cinema.listener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caelum.cinema.mocks.LogListenerMock;
import br.com.caelum.cinema.models.User;

public class LogListenerTest {
	
	@Rule
	public final ExpectedException expected = ExpectedException.none();
	private LogListenerMock logger;
	
	@Before
	public void setup(){
		logger = new LogListenerMock();
	}
	
	@Test
	public void shouldBeAbleLogAccessUserWhenValidUser(){
		//Arrange
		User user = new User("valid@email.com", "123");
		
		//Act
		logger.performAction(user);
		
		//Assert
		Assert.assertTrue(logger.performActionWasCalled);
		
	}
	
	@Test
	public void shouldNotBeAbleAuthenticateForExternalSystemWhenUserIsNull(){
		
		//Assert
		expected.expect(NullPointerException.class);
		expected.expectMessage("User is required.");
		
		
		//Arrange 
		User user = null;		
		
		//Act
		logger.performAction(user);
		
		
		Assert.assertFalse(logger.performActionWasCalled);
	}
}
