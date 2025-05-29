package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Track {
	@Id
	@Column(name = "track_id", length = 30)
	private String id;
	
	@Column(name = "song_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "artist")
	private Artist artist;
	
	@Column(name = "preview_url")
	private String previewURL;
	
	@Column(name = "image_url")
	private String imageURL;

	public Track() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
