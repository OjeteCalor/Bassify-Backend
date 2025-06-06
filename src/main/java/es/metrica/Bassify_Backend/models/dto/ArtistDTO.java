package es.metrica.Bassify_Backend.models.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.metrica.Bassify_Backend.models.entity.Artist;

public class ArtistDTO {
	@JsonProperty("id")
	private String spotifyId;
	private String name;
	private List<String> genres;
	
	public ArtistDTO() {}

	public ArtistDTO(Artist artist) {
		this.artistSpotifyId = artist.getSpotifyId();
		this.artistName = artist.getName();
		this.genres = artist.getGenres();
  }
  
	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
}
