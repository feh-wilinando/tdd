package br.com.caelum.cinema.controllers;

import br.com.caelum.cinema.converters.ProviderConverter;
import br.com.caelum.cinema.converters.UserConverter;
import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.infra.RequestParams;
import br.com.caelum.cinema.listener.LoginListeners;
import br.com.caelum.cinema.models.LoginProvider;
import br.com.caelum.cinema.models.User;

public class LoginController {	
	private UserConverter userConverter;
	private ProviderConverter providerConverter;
	private LoginListeners listeners;
	private User user;

	public LoginController(UserConverter userConverter, ProviderConverter providerConverter,	LoginListeners listeners) {
		this.userConverter = userConverter;
		this.providerConverter = providerConverter;
		this.listeners = listeners;
	}

	public String login(RequestParams params) {

		if (isAuthenticated(params)) {
			
			listeners.notify(user);
			
			return "redirect:/home";
		}

		return "login";
	}

	private boolean isAuthenticated(RequestParams params) {
		try {
			user = userConverter.from(params);
			LoginProvider provider = providerConverter.from(params);

			return provider.authenticate(user);
		} catch (ParamNotFoundException e) {
			return false;
		}
	}		
}
