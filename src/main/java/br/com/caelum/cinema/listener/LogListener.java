package br.com.caelum.cinema.listener;

import java.util.Objects;

import br.com.caelum.cinema.models.User;

public class LogListener implements LoginListener {

	@Override
	public void performAction(User user) {
		Objects.requireNonNull(user, "User is required.");
		
		System.out.println("User " + user.getEmail() + " was logged in main system.");
	}

}
