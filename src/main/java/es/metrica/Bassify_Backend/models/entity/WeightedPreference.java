package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WeightedPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long preferenceId;
	private String genre;
	private Long likedSongsCount;
	private Long listenedSongCount;
	@ManyToOne
	private User user;
	
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

	public Long getLikedSongsCount() {
		return likedSongsCount;
	}

	public void setLikedSongsCount(Long likedSongsCount) {
		this.likedSongsCount = likedSongsCount;
	}

	public Long getListenedSongCount() {
		return listenedSongCount;
	}

	public void setListenedSongCount(Long listenedSongCount) {
		this.listenedSongCount = listenedSongCount;
	}
	
	
}
