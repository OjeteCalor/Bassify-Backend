package es.metrica.Bassify_Backend.models.dto;

import es.metrica.Bassify_Backend.models.entity.Artist;

public class ArtistDTO {
	
	private String artistSpotifyId;
	private String artistName;
	
	public ArtistDTO() {}

	public ArtistDTO(Artist artist) {
		this.artistSpotifyId = artist.getArtistSpotifyId();
		this.artistName = artist.getArtistName();
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
	
}
