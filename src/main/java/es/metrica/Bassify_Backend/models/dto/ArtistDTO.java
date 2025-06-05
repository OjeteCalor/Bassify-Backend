package es.metrica.Bassify_Backend.models.dto;

import java.util.List;

public class ArtistDTO {
	
	private String spotifyId;
	private String name;
	private List<String> genres;
	
	public ArtistDTO() {}

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
	
}
