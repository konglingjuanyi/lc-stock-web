package framework.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTools {
	
	public PropertiesTools(String url) {
		this.url=url;
	}

	private String url;

	public String getConfig(String configName) throws IOException {
		Properties properties = new Properties();
		if (url != null || url != "") {
			InputStream in = new FileInputStream(url);
			properties.load(in);
		}else{
			throw new IOException("URL Not Exists");
		}
		String configValue = properties.getProperty(configName).trim();
		return configValue;
	}
}