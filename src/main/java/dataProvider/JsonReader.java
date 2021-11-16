package dataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static JSONObject loadJson(String path) throws FileNotFoundException, IOException, ParseException {

		JSONParser browserProp = new JSONParser();
		JSONObject jsonobj = (JSONObject) browserProp.parse(new FileReader(path));

		return jsonobj;
	}

	// get data from json
	public static JSONObject getJsonProperty(String jsonkey, JSONObject jsonobj) {
		JSONObject jsonobjdetails = (JSONObject) jsonobj.get(jsonkey);

		return jsonobjdetails;
	}

}
