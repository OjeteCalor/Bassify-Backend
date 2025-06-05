package es.metrica.Bassify_Backend.models.logic;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.metrica.Bassify_Backend.models.dto.ArtistDTO;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.properties.PropertiesSingleton;

public class ArtistRequest {
	private static final String API_REQUEST = "https://api.spotify.com/v1/artists/{id}";

	Optional<ArtistDTO> getTracks(String id) {

		RestTemplate restTemplate = new RestTemplate();
		String accessToken = AccesToken.getAccessToken(PropertiesSingleton.getProperties().getProperty("refreshToken"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);

		URI url = UriComponentsBuilder.fromUriString(API_REQUEST)
										.encode()
										.build()
										.expand(id)
										.toUri();

		ResponseEntity<ArtistDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, ArtistDTO.class);
		
		if (response.hasBody())
			return Optional.of(response.getBody());
		else
			return Optional.empty();
	}
}
