package br.com.caelum.cinema.listener;

import java.util.ArrayList;

import br.com.caelum.cinema.models.User;

public class LoginListeners {

	
	
	private ArrayList<LoginListener> allListeners = new ArrayList<>();

	public void add(LoginListener listener) {
		allListeners .add(listener);
	}

	public void notify(User user) {
		allListeners.forEach(listener -> listener.performAction(user));
	}

}
