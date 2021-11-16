package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();

    public PropertyReader(String filepath) {
        loadProperties(filepath);
    }

    private void loadReader(BufferedReader reader) {
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    private void loadProperties(String filepath) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			properties = new Properties();
			loadReader(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + filepath);
		}	
		
		}
    
    public String readProperty(String key) {
        return properties.getProperty(key);
    }
    
	
}
