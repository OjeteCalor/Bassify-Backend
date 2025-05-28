package es.metrica.Bassify_Backend.models.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	private String userId;
	private Set<Track> listened;
	private String refreshToken;
	
	@OneToMany(mappedBy = "user")
	private Set<Preference> preferences;
}
