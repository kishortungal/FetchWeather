package PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;
 
public class CommonFunctions {
 WebDriver driver;
 
 public CommonFunctions(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 }
 
 public String getPageTitle() {
	 return driver.getTitle();
 }
 
 public String getURL() {
	 return driver.getCurrentUrl();
 }
 
 public void waitForPageLoaded() {
     ExpectedCondition<Boolean> expectation = new
             ExpectedCondition<Boolean>() {
                 public Boolean apply(WebDriver driver) {
                     return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                 }
             };
     try {
         Thread.sleep(1000);
         WebDriverWait wait = new WebDriverWait(driver, 60);
         wait.until(expectation);
     } catch (Throwable error) {
         Assert.fail("Timeout waiting for Page Load Request to complete.");
     }
 }
}