package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class WeatherPage {
 WebDriver driver;
 
 @FindBy(css="input#searchBox")
 WebElement SearchBox;
 
 public WeatherPage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 }
 
public void pinCity(String city) throws Exception {
	// TODO Auto-generated method stub
	try {
	if (SearchBox.isDisplayed()) {		
		Actions act = new Actions(driver);
		act.moveToElement(SearchBox).click().sendKeys(city).build().perform();		
		WebElement SearchBoxCity = driver.findElement(By.cssSelector("input#"+city));
		
		if (SearchBoxCity.isDisplayed()) {			
			if (!SearchBoxCity.isSelected()) {
				SearchBoxCity.click();
			}				
		}		
	}
	else {
		throw new Throwable("Search Box Not Visisble");		
	}
} catch (Throwable error) {
    Assert.fail("Verify Web elements in Weather Page" + error);
}
}

public String getTemparature(String city) throws Exception {
	// TODO Auto-generated method stub
	try {
		WebElement cityContainer = driver.findElement(By.cssSelector("div[class='outerContainer'][title='"+city+"']"));
	if (cityContainer.isDisplayed()) {
		return 	cityContainer.findElement(By.cssSelector("span[class='tempRedText']")).getText();	
	}
	else {
		throw new Throwable("City is not Visisble in the map");		
	}
} catch (Throwable error) {
    Assert.fail("Verify Web elements in Weather Page" + error);
}
	return null;
}
 
}