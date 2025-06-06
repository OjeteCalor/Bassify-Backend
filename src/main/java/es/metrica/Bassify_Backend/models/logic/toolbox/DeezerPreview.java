package es.metrica.Bassify_Backend.models.logic.toolbox;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeezerPreview {

    public static String getTrackPreview(String artist, String name) {
        String previewUrl = null;
        
        HttpClient client = HttpClient.newHttpClient();
        String url = "http://api.deezer.com/search?q=artist:%22" + artist.toLowerCase().replace(" ", "%20").replace("\"", "%22") + "%22%20track:%22" + name.toLowerCase().replace(" ", "%20").replace("\"", "%22") + "%22";
        
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode rootNode = objectMapper.readTree(response.body());
	        JsonNode firstTrack = rootNode.path("data").get(0);
	        previewUrl = firstTrack.path("preview").asText();
		} catch (IOException | InterruptedException |NullPointerException e) {
			//TODO: Comunicar que no existe
		}
        return previewUrl;
    }
}
