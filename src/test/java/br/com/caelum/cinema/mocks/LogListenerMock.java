package br.com.caelum.cinema.mocks;

import br.com.caelum.cinema.listener.LogListener;
import br.com.caelum.cinema.models.User;

public class LogListenerMock extends LogListener {
	public boolean performActionWasCalled;

	@Override
	public void performAction(User user) {
		performActionWasCalled = true;
		super.performAction(user);
	}
}
