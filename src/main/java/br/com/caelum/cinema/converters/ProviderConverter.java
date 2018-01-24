package br.com.caelum.cinema.converters;

import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.infra.RequestParams;
import br.com.caelum.cinema.models.LoginProvider;

public class ProviderConverter implements Converter<LoginProvider> {

	@Override
	public LoginProvider from(RequestParams params) throws ParamNotFoundException {
		try {
			return LoginProvider.valueOf(params.getParameter("provider"));
		}catch (IllegalArgumentException e) {
			throw new ParamNotFoundException("Param provider not found in request");
		}
	}
	
}
