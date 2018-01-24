package br.com.caelum.cinema;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.caelum.cinema.controllers.LoginControllerTest;
import br.com.caelum.cinema.converters.ProviderConvertTest;
import br.com.caelum.cinema.converters.UserConverterTest;
import br.com.caelum.cinema.learning.HashForStringTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginControllerTest.class, 
	ProviderConvertTest.class, 
	UserConverterTest.class,
	HashForStringTest.class
})
public class TestSuite {

}
