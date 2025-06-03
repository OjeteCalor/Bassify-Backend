package es.metrica.Bassify_Backend.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;

public class PropertiesSingleton {
	protected static Properties p;
	public static Properties getProperties() {
		if(p == null) {
			p = new Properties();
			p = new Properties();
			try(InputStream input = AccesToken.class.getClassLoader().getResourceAsStream("accestoken.properties")){
				p.load(input);
			} catch (IOException e) {
				System.exit(1);
			}
		}
		return p;
	}
}
