package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long songId;
	private String trackSpotifyId;
	private String name;
	@ManyToOne
	private Artist artist;
	private String previewURL;
	private String imageURL;

	public Track() {
	}

}
