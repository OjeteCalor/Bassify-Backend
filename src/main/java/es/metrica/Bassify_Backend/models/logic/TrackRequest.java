package es.metrica.Bassify_Backend.models.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.models.logic.toolbox.JsonParser;
import es.metrica.Bassify_Backend.properties.PropertiesSingleton;

public class TrackRequest {
	
	private static final String API_REQUEST = "https://api.spotify.com/v1/search?q={query}&type={type}&limit={limit}&offset={offset}";
	
	List<TrackDTO> getTrackResponse(String genre){
		return getTrackResponse(genre, 0);
	}
	
	List<TrackDTO> getTrackResponse(String genre, int limit){
		return getTrackResponse(genre, limit, 0);
	}
	
	List<TrackDTO> getTrackResponse(String genre, int limit, int offset){
		RestTemplate restTemplate = new RestTemplate();
		String accessToken = AccesToken.getAccessToken(PropertiesSingleton.getProperties().getProperty("refreshToken"));
        String url = API_REQUEST;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<>();
        
        params.put("query", genre);
        params.put("type", "track");
        params.put("limit", String.valueOf(limit));
        params.put("offset", String.valueOf(offset));
      
        ResponseEntity<TrackDTO[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                TrackDTO[].class,
                params
        );

        
//        return response.getBody();
        return null;
	}
}
