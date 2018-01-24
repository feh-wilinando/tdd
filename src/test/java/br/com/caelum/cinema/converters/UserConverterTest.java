package br.com.caelum.cinema.converters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.cinema.converters.UserConverter;
import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.mocks.RequestParamsMock;
import br.com.caelum.cinema.models.User;


public class UserConverterTest {
	
	private RequestParamsMock paramsMock;
	private UserConverter converter;

	@Before
	public void setup(){
		converter = new UserConverter();
		paramsMock = new RequestParamsMock();		
	}
	
	@Test
	public void shouldBePossibleCastStringOfEmailAndPasswordToUser(){
		
		//Arrange
		paramsMock.valueFor("email", "im@email.com");
		paramsMock.valueFor("password", "123");							
		
		//Act
		User user = converter.from(paramsMock);
		
		//Assert
		Assert.assertEquals("im@email.com", user.getEmail());
		Assert.assertEquals("123", user.getPassword());
		
		
	}
	
	@Test(expected=ParamNotFoundException.class)
	public void shouldThrowParamNotFoundExceptionWhenRequestNotContainsEmailParameter(){
		
		//Arrange	
		paramsMock.valueFor("password", "123");
		
		//Act
		converter.from(paramsMock);
		
		//Assert in annotation		
		
	}
	
	
	@Test(expected=ParamNotFoundException.class)
	public void shouldThrowParamNotFoundExceptionWhenRequestNotContainsPasswordParameter(){
		
		//Arrange	
		paramsMock.valueFor("email", "im@email.com");
		
		//Act
		converter.from(paramsMock);
		
		//Assert in annotation		
		
	}
	
	
	@Test(expected=ParamNotFoundException.class)
	public void shouldThrowParamNotFoundExceptionWhenRequestNotContainsEmailAndPasswordParameters(){
		
		//Arrange					
		//Act
		converter.from(paramsMock);
		
		//Assert in annotation		
		
	}
}
