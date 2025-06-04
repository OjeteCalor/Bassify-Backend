package es.metrica.Bassify_Backend.models.entity;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackId;
	private String trackSpotifyId;
	private String name;
	@ManyToOne
	private Artist artist;
	private String previewURL;
	private String imageURL;

	public Track() {}
	
	public Track(TrackDTO a) {
		this.trackSpotifyId = a.getTrackSpotifyId();
		this.name = a.getName();
		this.artist = new Artist(a.getArtist());
		this.previewURL = a.getPreviewURL();
		this.imageURL = a.getImageURL();
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getTrackSpotifyId() {
		return trackSpotifyId;
	}

	public void setTrackSpotifyId(String trackSpotifyId) {
		this.trackSpotifyId = trackSpotifyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getPreviewURL() {
		return previewURL;
	}

	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
