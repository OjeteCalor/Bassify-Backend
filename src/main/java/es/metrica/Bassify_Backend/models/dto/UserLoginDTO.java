package es.metrica.Bassify_Backend.models.dto;

import es.metrica.Bassify_Backend.models.entity.User;

public class UserLoginDTO {

	private String spotifyId;

	public UserLoginDTO() {}

	public UserLoginDTO(User user) {
		this.spotifyId = user.getSpotifyId();
	}
	
	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}
	
}
