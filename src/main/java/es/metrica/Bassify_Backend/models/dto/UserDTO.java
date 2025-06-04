package es.metrica.Bassify_Backend.models.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import es.metrica.Bassify_Backend.models.entity.User;

public class UserDTO {
	
	private String spotifyId;
	private String refreshToken;
	private Set<TrackDTO> listenedTracks;
	private Set<WeightedPreferenceDTO> preferences;
	
	public UserDTO() {
		listenedTracks = new HashSet<>();
		preferences = new HashSet<>();
	}
	
	public UserDTO(User user) {
		this.spotifyId = user.getSpotifyId();
		this.listenedTracks = user.getListenedTracks().stream().map(a -> new TrackDTO(a)).collect(Collectors.toSet());
		this.preferences = user.getPreferences().stream().map(a -> new WeightedPreferenceDTO(a)).collect(Collectors.toSet());
	}

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Set<TrackDTO> getListenedTracks() {
		return listenedTracks;
	}

	public void setListenedTracks(Set<TrackDTO> listenedTracks) {
		this.listenedTracks = listenedTracks;
	}

	public Set<WeightedPreferenceDTO> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<WeightedPreferenceDTO> preferences) {
		this.preferences = preferences;
	}

	
	
}
