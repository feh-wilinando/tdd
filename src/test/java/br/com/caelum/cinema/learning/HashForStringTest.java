package br.com.caelum.cinema.learning;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.junit.Assert;
import org.junit.Test;

public class HashForStringTest {

	@Test
	public void shouldBeAbleMakeHashToValueOf123456() throws NoSuchAlgorithmException{
		//Arrange
		String rawValue = "123456";
		MessageDigest hasher = MessageDigest.getInstance("SHA-256");
		HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();		
		
		byte[] hashedBytes = hasher.digest(rawValue.getBytes());
								
		//Act
		String hashedValue = hexBinaryAdapter.marshal(hashedBytes);
					
		//Assert
		Assert.assertEquals("8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92", hashedValue);
	}
	
}
