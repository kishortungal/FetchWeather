package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
 
public class HomePage {
 WebDriver driver;
 private List<WebElement> webElements;
 
 @FindBy(css="a#h_sub_menu")
 WebElement SubMenu;
 
 @FindBy(linkText="WEATHER")
 WebElement WeatherLink;
 
 public HomePage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 }
 
 public void navigateTo_HomePage() {
 driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
 }
 
public void naigateToLinkByText(String LinkText) throws Exception {
	
	if (LinkText.toUpperCase().contains("WEATHER")) {
		try {
			SubMenu.click();
			WeatherLink.click();
			}
		catch (Exception e) {
		System.out.println("Register element is not found.");
		throw(e);
		}
	}
}
 
}