package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {
	private static ConfigFileReader configFileReader;
	 
	private FileReaderManager() {
		// private constructor
	}
 
    // static inner class - inner classes are not loaded until they are
    // referenced.
	private static class FileReaderManagerHolder{
		private static FileReaderManager fileReaderManager = new FileReaderManager();
	 }
	// global access point
	 public static FileReaderManager getInstance() {
		 return FileReaderManagerHolder.fileReaderManager;
	 }
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
}
