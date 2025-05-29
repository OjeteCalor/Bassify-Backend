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
	private Set<Track> listenedTracks;
	private String refreshToken;
	
	@OneToMany(mappedBy = "preferenceId", fetch = FetchType.LAZY)
	private Set<WeightedPreference> preferences;
	
	
}
