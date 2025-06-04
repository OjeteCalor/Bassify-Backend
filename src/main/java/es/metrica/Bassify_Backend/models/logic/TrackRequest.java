package es.metrica.Bassify_Backend.models.logic;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.metrica.Bassify_Backend.models.dto.SearchDTO;
import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.properties.PropertiesSingleton;

public class TrackRequest {

	private static final String API_REQUEST = "https://api.spotify.com/v1/search?q=genre:{genre}&type={type}&limit={limit}&offset={offset}";

	List<TrackDTO> getTracks(String genre) {
		return getTracks(genre, 1);
	}

	List<TrackDTO> getTracks(String genre, int limit) {
		return getTracks(genre, limit, 0);
	}

	List<TrackDTO> getTracks(String genre, int limit, int offset) {

		RestTemplate restTemplate = new RestTemplate();
		String accessToken = AccesToken.getAccessToken(PropertiesSingleton.getProperties().getProperty("refreshToken"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		URI url = UriComponentsBuilder.fromUriString(API_REQUEST).encode().build().expand(genre, "track", limit, offset)
				.toUri();

		ResponseEntity<SearchDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, SearchDTO.class);
		if (response.hasBody())
			return response.getBody().getTracksDTO();
		else
			return new ArrayList<>();
	}
}
