package cucumber;

import managers.ApiManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;
	private ApiManager apiManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	
	public TestContext(){
		//webDriverManager = new WebDriverManager();
		//apiManager = new ApiManager();
		//pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		//scenarioContext = new ScenarioContext();
	}
	
	public WebDriverManager getWebDriverManager() {
		if(webDriverManager == null)
			webDriverManager = new WebDriverManager();
		return webDriverManager;
	}
	
	public ApiManager getApiManager() {
		if(apiManager == null)
			apiManager = new ApiManager();
		return apiManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			if(webDriverManager == null)
				webDriverManager = new WebDriverManager();
			pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		}
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		if(scenarioContext == null)
			scenarioContext = new ScenarioContext();
		return scenarioContext;
	}

}