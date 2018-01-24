package br.com.caelum.cinema.mocks;

import br.com.caelum.cinema.listener.ExternalAuthenticationListener;
import br.com.caelum.cinema.models.User;

public class ExternalAuthenticationListenerMock extends ExternalAuthenticationListener {
	public boolean performActionWasCalled;

	@Override
	public void performAction(User user) {
		performActionWasCalled = true;
		
		super.performAction(user);
	}
}
