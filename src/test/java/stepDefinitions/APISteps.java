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
public class APISteps  {
	
	Response response;
	TestContext testContext;
	ApiManager apiManager;
	ScenarioContext scenarioContext;
	
	public APISteps(TestContext context) {
		testContext = context;
		apiManager = testContext.getApiManager();
		scenarioContext = testContext.getScenarioContext();
	}	
	
	//BasicConfigurator.configure();
	private final Logger logger = LoggerFactory.getLogger(APISteps.class);
	
	
	@When("I check the status code fo repsonse")
	public void check_status_code() {
	    
	}
	
	@Then("API Response code is {string}")
	public void validate_Reposnse_Code(String expected_Code) {
		
		assertEquals(response.getStatusCode(), Integer.parseInt(expected_Code));		
		
	}
	

@When("User requests Temperature of pinned City from Weather API")
public void getTemperatureByAPI() throws IOException {
	
	RequestSpecification requestSpecification = apiManager.getBaseRequestSpecification();
	String city = scenarioContext.getContext(ContextType.CityName);
	requestSpecification=requestSpecification
			.queryParam("q", city)
			.queryParam("units", "metric");
	
	response =given().spec(requestSpecification).get();	
	ResponseBody body = response.getBody();
	
	weatherData weatherDataObject = body.as(weatherData.class);
	
	String Temperature = weatherDataObject.getMain().getTemp().toString();
	
	scenarioContext.setContext(ContextType.ApiTemparature,Temperature  );
	
}


	

}
