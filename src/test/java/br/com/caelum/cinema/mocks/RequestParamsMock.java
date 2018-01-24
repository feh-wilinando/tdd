package br.com.caelum.cinema.mocks;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.cinema.infra.RequestParams;

public class RequestParamsMock implements RequestParams{

	private Map<String, String> params = new HashMap<>();
	
	
	public void valueFor(String key, String value) {
		params.put(key, value);
	}
	
	@Override
	public String getParameter(String key) {
		if (params.containsKey(key)){
			return params.get(key);
		}
		
		throw new IllegalArgumentException("Parameter "+key+" not found");
	}
}
