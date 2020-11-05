package managers;

	import org.openqa.selenium.WebDriver;
	import PageObjects.HomePage;
	import PageObjects.WeatherPage;
	import PageObjects.CommonFunctions;

public class PageObjectManager {
	private WebDriver driver;
	private WeatherPage weatherPage;
	private HomePage homePage;
	private CommonFunctions commonFunctions;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public WeatherPage getWeatherPage() {
		return (weatherPage == null) ? weatherPage = new WeatherPage(driver) : weatherPage;
	}
	
	public CommonFunctions getcommonFunctions() {
		return (commonFunctions == null) ? commonFunctions = new CommonFunctions(driver) : commonFunctions;
	}
	
}