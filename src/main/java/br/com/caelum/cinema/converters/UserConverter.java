package br.com.caelum.cinema.converters;

import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.infra.RequestParams;
import br.com.caelum.cinema.models.User;

public class UserConverter implements Converter<User> {

	@Override
	public User from(RequestParams params)  throws ParamNotFoundException {
		
		try{
			String email = params.getParameter("email");
			String password = params.getParameter("password");
			
			return new User(email, password);
		}catch (IllegalArgumentException e) {
			throw new ParamNotFoundException("Param email or passwor not found in request!");
		}			
		
	}

}
