package es.metrica.Bassify_Backend.models.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long artistId;
	private String artistSpotifyId;
	private String artistName;
	private List<String> artistGenres;

	public Artist() {}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
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

	public List<String> getArtistGenres() {
		return artistGenres;
	}

	public void setArtistGenres(List<String> artistGenres) {
		this.artistGenres = artistGenres;
	}

	
}