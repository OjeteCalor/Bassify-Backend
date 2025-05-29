package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WeightedPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long preferenceId;
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	@ManyToOne
	private User preferenceUser;
	
	public WeightedPreference() {}

	public Long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getLikedTracksCount() {
		return likedTracksCount;
	}

	public void setLikedTracksCount(Long likedTracksCount) {
		this.likedTracksCount = likedTracksCount;
	}

	public Long getListenedTracksCount() {
		return listenedTracksCount;
	}

	public void setListenedTracksCount(Long listenedTracksCount) {
		this.listenedTracksCount = listenedTracksCount;
	}

	public User getPreferenceUser() {
		return preferenceUser;
	}

	public void setPreferenceUser(User preferenceUser) {
		this.preferenceUser = preferenceUser;
	}
	
	
}
