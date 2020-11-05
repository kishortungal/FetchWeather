package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import POJO.createNewRepo;
import POJO.weatherData;
import PageObjects.CommonFunctions;
import PageObjects.HomePage;
import PageObjects.WeatherPage;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import enums.ContextType;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import managers.ApiManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class CommonSteps  {
	
	TestContext testContext;
	ScenarioContext scenarioContext;
	
	public CommonSteps(TestContext context) {
		testContext = context;
		scenarioContext = testContext.getScenarioContext();
	}	
	
	//BasicConfigurator.configure();
	private final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
	
	
	@Then("Temparature difference bewteen Web and API is not more than {string}")
	public void temparature_difference_bewteen_Web_and_API_is_not_more_than(String threshold) {
		double  WebTemp = Double.parseDouble(scenarioContext.getContext(ContextType.WebPageTemparature));
		double  ApiTemp = Double.parseDouble(scenarioContext.getContext(ContextType.ApiTemparature));
		double threshold_double = Double.parseDouble(threshold);
		if (Math.abs(WebTemp - ApiTemp) > threshold_double) {
			Assert.fail("Temparature difference bewteen Web and API is not more than "+threshold);
		}		
	}
}
