package es.metrica.Bassify_Backend.models.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PreferenceKey implements Serializable{
	
	private String userCode;
	private String genre;
	
	public PreferenceKey(String userCode, String genre) {
		super();
		this.userCode = userCode;
		this.genre = genre;
	}
	
	
}
