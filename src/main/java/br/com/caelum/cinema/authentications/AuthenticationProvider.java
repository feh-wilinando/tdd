package br.com.caelum.cinema.authentications;

import br.com.caelum.cinema.models.User;

public interface AuthenticationProvider {
	boolean authenticate(User user);
}
