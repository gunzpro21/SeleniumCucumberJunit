package utilitiesForTest;

import dataProvider.PropertyReader;
import io.restassured.RestAssured;
import utilities.AppVariables;

public class RestAssure {
	//TODO apply RestAssure for testing
/*	public static String getAPIPath(){
		return new PropertyReader("/com/YOUR_PROJECT/properties/url.properties").readProperty(AppVariables.APP_ENV+".fromPrice.api.path");
	}
	
	public static String getAPIToken(){
		return new PropertyReader("/com/YOUR_PROJECT/properties/url.properties").readProperty(AppVariables.APP_ENV+".fromPrice.api.token");
	}

	
	
	public static void assertResponse(String var1, String var2, String response){
		
		
		RestAssured.baseURI = getAPIPath();

		String apiToken = getAPIToken();
		
		//RestAssured.get(var1+var2+apiToken).then().assertThat().body("responceData",equalTo(response));

	}*/


}