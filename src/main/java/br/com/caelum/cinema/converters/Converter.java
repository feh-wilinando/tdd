package br.com.caelum.cinema.converters;


import br.com.caelum.cinema.converters.exceptions.ParamNotFoundException;
import br.com.caelum.cinema.infra.RequestParams;

public interface Converter<Target> {
	public Target from(RequestParams params) throws ParamNotFoundException;
}
