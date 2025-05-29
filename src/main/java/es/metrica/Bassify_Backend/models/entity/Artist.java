package es.metrica.Bassify_Backend.models.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@Column(name = "artist_id", length = 30)
	private String id;
	
	@Column(name = "artist_name", length = 100)
	private String name;
	
	@Column(name = "genres")
	private List<String> genres;
	
	public Artist() {}

	public String getSpotifyId() {
		return id;
	}

	public void setSpotifyId(String spotifyId) {
		this.id = spotifyId;
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