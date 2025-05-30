package es.metrica.Bassify_Backend.models.entity;

import java.util.Set;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
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
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<WeightedPreference> preferences;
	
	public User() {}

	public User(UserDTO userDto) {
		this.spotifyId = userDto.getSpotifyId();
		this.listenedTracks = userDto.getListenedTracks();
		this.preferences = userDto.getPreferences();
	}

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
	
}
