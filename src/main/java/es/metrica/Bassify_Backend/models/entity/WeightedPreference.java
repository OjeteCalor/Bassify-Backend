package es.metrica.Bassify_Backend.models.entity;

import es.metrica.Bassify_Backend.models.dto.WeightedPreferenceDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WeightedPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long preferenceId;
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public WeightedPreference() {}

	public WeightedPreference(WeightedPreferenceDTO a) {
		this.genre = a.getGenre();
		this.likedTracksCount = a.getLikedTracksCount();
		this.listenedTracksCount = a.getListenedTracksCount();
		this.user = new User(a.getUser());
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
