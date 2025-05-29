package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Entity;

@Entity
public class WeightedPreference {
	private Long preferenceId;
	private String genre;
	private Long likedSongsCount;
	private Long listenedSongCount;
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
