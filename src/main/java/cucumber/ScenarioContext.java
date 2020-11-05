package cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.ContextType;

public class ScenarioContext {
	 
	private  Map<ContextType, String> scenarioContext;

	    public ScenarioContext(){
	        scenarioContext = new HashMap<ContextType, String>();
	    }

	    public void setContext(ContextType key, String value) {
	        scenarioContext.put(key, value);
	    }

	    public String getContext(ContextType key){
	        return scenarioContext.get(key);
	    }

	    public Boolean isContains(ContextType key){
	        return scenarioContext.containsKey(key);
	    }

}
