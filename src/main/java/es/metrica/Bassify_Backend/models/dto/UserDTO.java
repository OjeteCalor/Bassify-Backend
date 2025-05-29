package es.metrica.Bassify_Backend.models.dto;

import java.util.Set; 

import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;

public class UserDTO {
	
	private String spotifyId;
	private Set<Track> listenedTracks;
	private Set<WeightedPreference> preferences;
	
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
	public Set<WeightedPreference> getPreferences() {
		return preferences;
	}
	public void setPreferences(Set<WeightedPreference> preferences) {
		this.preferences = preferences;
	}
	
}
