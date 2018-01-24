package br.com.caelum.cinema.authentications;

import br.com.caelum.cinema.models.User;

public class FacebookProvider implements AuthenticationProvider {

	@Override
	public boolean authenticate(User user) {
		System.out.println("Authenticating user " + user.getEmail() + " via Facebook.");
		return true;
	}

}
