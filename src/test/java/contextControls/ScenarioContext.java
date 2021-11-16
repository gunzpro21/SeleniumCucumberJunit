package contextControls;

import java.util.HashMap;
import java.util.Map;

import enums.E_Context;


public class ScenarioContext {
	private  Map<String, Object> scenarioContext;
	 
    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(E_Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(E_Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(E_Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
