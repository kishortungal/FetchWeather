package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import POJO.createNewRepo;
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
import managers.PageObjectManager;
import managers.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class WeatherPageSteps  {

	TestContext testContext;
	HomePage homePage;
	WeatherPage weatherPage;
	CommonFunctions commonFunctions;
	ScenarioContext scenarioContext;
	
	public WeatherPageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		weatherPage = testContext.getPageObjectManager().getWeatherPage();
		commonFunctions = testContext.getPageObjectManager().getcommonFunctions();
		scenarioContext = testContext.getScenarioContext();
	}
	
	//BasicConfigurator.configure();
	private final Logger logger = LoggerFactory.getLogger(WeatherPageSteps.class);
	
	

@When("User Search for {string} City and pins in Weather Page")
public void user_Search_for_City_And_Pins(String City) throws Exception {
	weatherPage.pinCity(City);
	scenarioContext.setContext(ContextType.CityName, City);
}

@When("User Notes the Temperature of pinned City from Weather Page")
public void user_Notes_the_Temperature_of_Pinned_City() throws Exception {
	String temparature = weatherPage.getTemparature(scenarioContext.getContext(ContextType.CityName));
	scenarioContext.setContext(ContextType.WebPageTemparature, temparature.replace("℃", ""));
}






	


	

}
