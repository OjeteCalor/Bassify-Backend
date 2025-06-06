package es.metrica.Bassify_Backend.models.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trackId;
	private String trackSpotifyId;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	private Artist artist;
	@Lob
	private String previewURL;
	private String imageURL;

	public Track() {}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getTrackSpotifyId() {
		return trackSpotifyId;
	}

	public void setTrackSpotifyId(String trackSpotifyId) {
		this.trackSpotifyId = trackSpotifyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getPreviewURL() {
		return previewURL;
	}

	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", name=" + name + ", artist=" + artist + "]";
	}
	
}
