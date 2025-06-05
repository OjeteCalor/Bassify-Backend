package es.metrica.Bassify_Backend.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.metrica.Bassify_Backend.models.entity.Artist;

public class ArtistDTO {
	@JsonProperty("id")
	private String artistSpotifyId;
	@JsonProperty("name")
	private String artistName;
	private List<String> genres;
	
	public ArtistDTO() {}

	public ArtistDTO(Artist artist) {
		this.artistSpotifyId = artist.getArtistSpotifyId();
		this.artistName = artist.getArtistName();
		this.genres = artist.getArtistGenres();
	}
	
	public String getArtistSpotifyId() {
		return artistSpotifyId;
	}
	public void setArtistSpotifyId(String artistSpotifyId) {
		this.artistSpotifyId = artistSpotifyId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
}
