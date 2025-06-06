package es.metrica.Bassify_Backend.models.logic;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.metrica.Bassify_Backend.models.dto.ArtistDTO;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.properties.PropertiesSingleton;

public class ArtistRequest {
	private static final String GET_ARTIST_REQUEST = "https://api.spotify.com/v1/artists/{id}";
	private static final String GET_SEVERAL_ARTIST_REQUEST = "https://api.spotify.com/v1/artists/?ids={ids}";
	
	Optional<ArtistDTO> getArtist(String id) {

		RestTemplate restTemplate = new RestTemplate();
		String accessToken = AccesToken.getAccessToken(PropertiesSingleton.getProperties().getProperty("refreshToken"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);

		URI url = UriComponentsBuilder.fromUriString(GET_ARTIST_REQUEST)
										.encode()
										.build()
										.expand(id)
										.toUri();

		ResponseEntity<ArtistDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, ArtistDTO.class);
		
		if (response.getStatusCode() == HttpStatus.OK)
			return Optional.of(response.getBody());
		else
			return Optional.empty();
	}
	
	Optional<List<ArtistDTO>> getSeveralArtists(String... ids) {

		RestTemplate restTemplate = new RestTemplate();
		String accessToken = AccesToken.getAccessToken(PropertiesSingleton.getProperties().getProperty("refreshToken"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);

		URI url = UriComponentsBuilder.fromUriString(GET_SEVERAL_ARTIST_REQUEST)
										.encode()
										.build()
										.expand(String.join(",", ids))
										.toUri();

		ResponseEntity<ArtistList> response = restTemplate.exchange(url, HttpMethod.GET, entity, ArtistList.class);
		
		if (response.getStatusCode() == HttpStatus.OK)
			return Optional.of(response.getBody().getArtists());
		else
			return Optional.empty();
	}
}

class ArtistList {
	List<ArtistDTO> artists;
	
	public List<ArtistDTO> getArtists() {
		return artists;
	}
	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}
}
