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
	private Long trackId;
	private String trackSpotifyId;
	private String trackName;
	@ManyToOne
	private Artist trackArtist;
	private String trackPreviewURL;
	private String trackImageURL;
	private boolean trackIsLiked;

	public Track() {
	}

}
