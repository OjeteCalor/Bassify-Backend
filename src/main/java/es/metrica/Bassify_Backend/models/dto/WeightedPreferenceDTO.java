package es.metrica.Bassify_Backend.models.dto;

import es.metrica.Bassify_Backend.models.entity.WeightedPreference;

public class WeightedPreferenceDTO {
	
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	
	public WeightedPreferenceDTO() {}
	
	public WeightedPreferenceDTO(WeightedPreference pref) {
		this.genre = pref.getGenre();
		this.likedTracksCount = pref.getLikedTracksCount();
		this.listenedTracksCount = pref.getListenedTracksCount();
	}

	public WeightedPreferenceDTO(String genre, Long likedTracksCount, Long listenedTracksCount) {
		super();
		this.genre = genre;
		this.likedTracksCount = likedTracksCount;
		this.listenedTracksCount = listenedTracksCount;
	}
	
	public WeightedPreferenceDTO(String genre) {
		this(genre, 1l, 1l);
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
	
}
