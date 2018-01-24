package br.com.caelum.cinema.converters;

import static org.hamcrest.Matchers.containsString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.mocks.RequestParamsMock;
import br.com.caelum.cinema.models.LoginProvider;


public class ProviderConvertTest {

	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	private RequestParamsMock paramsMock;
	private ProviderConverter converter;


	@Before
	public void setup(){
		converter = new ProviderConverter();
		paramsMock = new RequestParamsMock();		
	}
	
	@Test
	public void shoulBeAbleCastStringEMAILToLoginProvider(){
		
		//Arrange
		paramsMock.valueFor("provider", "EMAIL");
							
		//Act
		LoginProvider convertedProvider = converter.from(paramsMock); 
		
		//Assert
		Assert.assertEquals(LoginProvider.EMAIL, convertedProvider);
		
	}
	
	
	@Test
	public void shoulBeAbleCastStringGPLUSToLoginProvider(){
		
		//Arrange
		paramsMock.valueFor("provider", "GPLUS");
				
		//Act
		LoginProvider convertedProvider = converter.from(paramsMock); 
		
		//Assert
		Assert.assertEquals(LoginProvider.GPLUS, convertedProvider);
		
	}
	
	@Test
	public void shoulBeAbleCastStringGITHUBToLoginProvider(){
		
		//Arrange
		paramsMock.valueFor("provider", "GITHUB");
				
		//Act
		LoginProvider convertedProvider = converter.from(paramsMock); 
		
		//Assert
		Assert.assertEquals(LoginProvider.GITHUB, convertedProvider);
		
	}
	
	@Test
	public void shoulBeAbleCastStringFACEBOOKToLoginProvider(){
		
		//Arrange
		paramsMock.valueFor("provider", "FACEBOOK");
				
		//Act
		LoginProvider convertedProvider = converter.from(paramsMock); 
		
		//Assert
		Assert.assertEquals(LoginProvider.FACEBOOK, convertedProvider);
		
	}
	
	
	@Test(expected=ParamNotFoundException.class)
	public void shoulNotBeAbleCastSomeStringToLoginProvider(){
		
		//Arrange
		paramsMock.valueFor("provider", "ASDS");
				
		//Act
		converter.from(paramsMock); 
		
		//Assert
		//Annotation Expected		
	}
	
	@Test
	public void shouldThrowExceptionWhenRequestParamNotContainsProviderKey(){
		//Arrange
		
		//Assert	
		expected.expect(ParamNotFoundException.class);		
		expected.expectMessage(containsString("provider not found"));
		
		//Act		
		converter.from(paramsMock); 
		
		Assert.fail("Test should not reach this line");
	}
}
