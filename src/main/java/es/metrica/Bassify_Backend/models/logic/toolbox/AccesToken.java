package es.metrica.Bassify_Backend.models.logic.toolbox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.metrica.Bassify_Backend.exceptions.BassifyException;

public class AccesToken {
	
	public static String getAccessToken(String refreshToken) throws BassifyException {
		String token = null;
		Properties p = new Properties();
		try(InputStream input = AccesToken.class.getClassLoader().getResourceAsStream("accestoken.properties")){
			p.load(input);
		} catch (IOException e) {
			throw new BassifyException("Properties file is corrupted or is missing");
		}
		
		String userId = p.getProperty("userId");
		String userSecret = p.getProperty("userSecret");
		
		String credentials = userId + ":" + userSecret;
		String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization","Basic " + base64Credentials);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "refresh_token");
		body.add("refresh_token", refreshToken);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity("https://accounts.spotify.com/api/token",
				request, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode nodes = mapper.readTree(response.getBody());
				token = nodes.get("access_token").asText();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	        return token;
	}
}
