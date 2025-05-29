package es.metrica.Bassify_Backend.models.dto;

import java.util.Set;

import es.metrica.Bassify_Backend.models.entity.Preference;
import es.metrica.Bassify_Backend.models.entity.Track;

public class UserDTO {
	
	private String id;
	private Set<Track> listened;
	private Set<Preference> preferences;
	
	public UserDTO() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<Track> getListened() {
		return listened;
	}
	public void setListened(Set<Track> listened) {
		this.listened = listened;
	}
	public Set<Preference> getPreferences() {
		return preferences;
	}
	public void setPreferences(Set<Preference> preferences) {
		this.preferences = preferences;
	}
	
	
	
}
