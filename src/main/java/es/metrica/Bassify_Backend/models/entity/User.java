package es.metrica.Bassify_Backend.models.entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String spotifyId;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "user_listened_tracks",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "track_id")
	)
	private Set<Track> listenedTracks;
	private String refreshToken;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // Si se elimina una preferencia del Set, también lo hace en la BBDD
	private Set<WeightedPreference> preferences;
	
	public User() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
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

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", spotifyId=" + spotifyId + ", listenedTracks=" + listenedTracks
				+ ", refreshToken=" + refreshToken + ", preferences=" + preferences + "]";
	}
	
	public void addPreferences(Set<WeightedPreference> preferences) {
		this.preferences.addAll(preferences);
	}
	
}
