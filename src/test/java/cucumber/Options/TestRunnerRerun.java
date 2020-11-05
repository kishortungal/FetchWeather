package cucumber.Options;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="@target/cucumber-reports/rerun.txt",
					glue= "stepDefinitions",					
					plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json"}
					) 
public class TestRunnerRerun {
	public TestRunnerRerun() throws IOException {

	}

}