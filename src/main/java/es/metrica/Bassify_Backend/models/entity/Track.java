package es.metrica.Bassify_Backend.models.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private boolean isLiked;
	@ManyToMany(mappedBy = "listenedTracks", fetch = FetchType.LAZY)
	private Set<User> usersWhoListened;


	public Track() {}


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


	public boolean isLiked() {
		return isLiked;
	}


	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}


	public Set<User> getUsersWhoListened() {
		return usersWhoListened;
	}


	public void setUsersWhoListened(Set<User> usersWhoListened) {
		this.usersWhoListened = usersWhoListened;
	}

	
}
