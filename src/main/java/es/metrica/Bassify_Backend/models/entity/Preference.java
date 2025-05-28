package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;

public class Preference {
	@EmbeddedId
	private PreferenceKey id;
	private Long weight;
	
	@MapsId("userCode")
	@JoinColumn(name = "id")
	private User user;
}
