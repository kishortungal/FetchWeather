package cucumber.Options;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features",
					glue= "stepDefinitions",
					tags = {"@twitter"},
					plugin = { "pretty", "json:target/cucumber-reports/rerun/Cucumber.json", "rerun:target/cucumber-reports/rerun.txt"}
					) 
public class TestRunner {

}

