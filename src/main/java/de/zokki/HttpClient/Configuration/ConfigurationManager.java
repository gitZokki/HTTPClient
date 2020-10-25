package de.zokki.HttpClient.Configuration;

import java.io.FileReader;

import com.google.gson.Gson;

import de.zokki.HttpClient.Utils.HTTPConfigurationException;

public class ConfigurationManager {
	private static ConfigurationManager conigManager = null;
	private static Configuration configuration = null;
	
	private ConfigurationManager() {
	}
	
	public static ConfigurationManager getInstace() {
		if(conigManager == null) {
			conigManager = new ConfigurationManager();
		}
		return conigManager;
	}
	
	public void loadConfiguationFile(String filePath) {
		try {
			configuration = new Gson().fromJson(new FileReader(filePath), Configuration.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Configuration getCurrentConfiguation() {
		if(configuration == null) {
			throw new HTTPConfigurationException("No Configuration is set.");
		}
		return configuration;
	}
}
