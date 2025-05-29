package es.metrica.Bassify_Backend.models.logic.toolbox;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.util.Base64;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class AccesToken {
	public static String getAccessToken() {
		Properties properties = new Properties();
		try(InputStream input = AccesToken.class.getClassLoader().getResourceAsStream("accestoken.properties")){
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String clientId = properties.getProperty("clientId");
		String clientSecret = properties.getProperty("clientSecret");
		
		String credentials = clientId + ":" + clientSecret;
		String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
		HttpHeaders headers = new HttpHeaders();
		
	        return null;
	}
}
