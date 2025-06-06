package es.metrica.Bassify_Backend.models.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WeightedPreference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long preferenceId;
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;
	
	public WeightedPreference() {}

	public WeightedPreference(Long preferenceId, String genre, Long likedTracksCount, Long listenedTracksCount,
			User user) {
		super();
		this.preferenceId = preferenceId;
		this.genre = genre;
		this.likedTracksCount = likedTracksCount;
		this.listenedTracksCount = listenedTracksCount;
		this.user = user;
		
		user.getPreferences().add(this);
	}

	public Long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getLikedTracksCount() {
		return likedTracksCount;
	}

	public void setLikedTracksCount(Long likedTracksCount) {
		this.likedTracksCount = likedTracksCount;
	}

	public Long getListenedTracksCount() {
		return listenedTracksCount;
	}

	public void setListenedTracksCount(Long listenedTracksCount) {
		this.listenedTracksCount = listenedTracksCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedPreference other = (WeightedPreference) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "WeightedPreference [preferenceId=" + preferenceId + ", genre=" + genre + ", likedTracksCount="
				+ likedTracksCount + ", listenedTracksCount=" + listenedTracksCount + ", user=" + user.getUserId() + "]";
	}
	
}
