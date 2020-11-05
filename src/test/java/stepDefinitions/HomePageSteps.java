package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import POJO.createNewRepo;
import PageObjects.CommonFunctions;
import PageObjects.HomePage;
import cucumber.TestContext;

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
public class HomePageSteps  {

	TestContext testContext;
	HomePage homePage;
	CommonFunctions commonFunctions;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		commonFunctions = testContext.getPageObjectManager().getcommonFunctions();
	}
	
	//BasicConfigurator.configure();
	private final Logger logger = LoggerFactory.getLogger(HomePageSteps.class);
	
	

@Given("User navigates to the website URL")
public void user_navigates_to_the_website_URL() {
	
	homePage.navigateTo_HomePage(); 
}

@When("User Navigate to {string} Page")
public void user_Navigate_to_Page(String LinkText) throws Exception {
	
	homePage.naigateToLinkByText(LinkText); 
	
	commonFunctions.waitForPageLoaded();
	//System.out.println("Page Title:" + commonFunctions.getPageTitle());
	assertEquals(commonFunctions.getPageTitle().toUpperCase().contains(LinkText), true);
}
	


	

}
