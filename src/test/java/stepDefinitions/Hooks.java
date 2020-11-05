package stepDefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.TestContext;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	private final Logger logger = LoggerFactory.getLogger(Hooks.class);
	TestContext testContext;
	public Hooks(TestContext context) {
		testContext = context;		
	}
		@Before
		public void beforeQuery()
		{
			//logger.info("Inside Hook");
		}
		
		@After
		public void tearUp(Scenario scenario){
			
			testContext.getWebDriverManager().closeDriver();
			
		}
}
