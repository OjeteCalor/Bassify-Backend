package es.metrica.Bassify_Backend.models.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userSpotifyId;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Track> listenedTracks;
	private String refreshToken;
	
	@OneToMany(mappedBy = "preferenceUser", fetch = FetchType.LAZY)
	private Set<WeightedPreference> preferences;
	
	public User() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserSpotifyId() {
		return userSpotifyId;
	}

	public void setUserSpotifyId(String userSpotifyId) {
		this.userSpotifyId = userSpotifyId;
	}

	public Set<Track> getListenedTracks() {
		return listenedTracks;
	}

	public void setListenedTracks(Set<Track> listenedTracks) {
		this.listenedTracks = listenedTracks;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Set<WeightedPreference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<WeightedPreference> preferences) {
		this.preferences = preferences;
	}
	
	
}
