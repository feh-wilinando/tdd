package br.com.caelum.cinema.learning;

import java.util.logging.Logger;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

class LogRule implements TestRule {
	private Logger logger;

	public Logger getLogger() {
		return this.logger;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				logger = Logger.getLogger(description.getTestClass().getName() + '.' + description.getDisplayName());				
				base.evaluate();
			}
		};
	}

}

public class RuleTest {
	@Rule
	public final LogRule logger = new LogRule();

	@Ignore("Test only for desmostration custom rule")
	@Test
	public void checkOutMyLogger() {
		final Logger log = logger.getLogger();
		log.warning("Your test is showing!");
	}
}
