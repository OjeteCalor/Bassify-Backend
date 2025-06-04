package es.metrica.Bassify_Backend.models.logic.toolbox;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TokenPetition {
	
	public static String getUserId(String token) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/me"))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();
        
        String idResponse = null;
        
        try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper mapper = new ObjectMapper();
			JsonNode id = mapper.readTree(response.body());
			idResponse = id.get("id").asText();
        } catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
        return idResponse;
	}
	
}
