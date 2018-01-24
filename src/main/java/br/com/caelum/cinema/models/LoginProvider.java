package br.com.caelum.cinema.models;

import br.com.caelum.cinema.authentications.AuthenticationProvider;
import br.com.caelum.cinema.authentications.EmailProvider;
import br.com.caelum.cinema.authentications.FacebookProvider;
import br.com.caelum.cinema.authentications.GPlustProvider;
import br.com.caelum.cinema.authentications.GitHubProvider;

public enum LoginProvider {
	EMAIL(new EmailProvider()), 
	GPLUS(new GPlustProvider()), 
	GITHUB(new GitHubProvider()), 
	FACEBOOK(new FacebookProvider());

	private AuthenticationProvider provider;
	
	private LoginProvider(AuthenticationProvider provider) {
		this.provider = provider;
	}
	
	public boolean authenticate(User user) {
		return provider.authenticate(user);
	}
}
