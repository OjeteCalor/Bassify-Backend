package es.metrica.Bassify_Backend.models.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@Column(name = "user_id", length = 32)
	private String userId;
	
	@Column(name = "listened_songs")
	private Set<Track> listened;
	
	@Column(name = "refresh_token", length = 600)
	private String refreshToken;
	
	@Column(name = "user_preferences")
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Preference> preferences;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<Track> getListened() {
		return listened;
	}

	public void setListened(Set<Track> listened) {
		this.listened = listened;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Set<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Preference> preferences) {
		this.preferences = preferences;
	}
	
	
}
