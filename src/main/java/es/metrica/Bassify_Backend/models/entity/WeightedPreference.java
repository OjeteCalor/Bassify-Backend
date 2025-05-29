package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Preference {
	@EmbeddedId
	@Column(name = "preference_id")
	private PreferenceId id;
	
	@Column(name = "weight")
	private Long weight;
	
	@MapsId("userCode")
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	public PreferenceId getId() {
		return id;
	}

	public void setId(PreferenceId id) {
		this.id = id;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
