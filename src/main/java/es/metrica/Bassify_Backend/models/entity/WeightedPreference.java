package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WeightedPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long preferenceId;
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	@ManyToOne
	private User preferenceUser;
	
	public WeightedPreference() {}
	
	
}
