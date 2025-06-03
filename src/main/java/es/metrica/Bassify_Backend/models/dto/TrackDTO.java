package es.metrica.Bassify_Backend.models.dto;

import es.metrica.Bassify_Backend.models.entity.Track;

public class TrackDTO {
	private String trackSpotifyId;
	private String name;
	private ArtistDTO artist;
	private String previewURL;
	private String imageURL;
	private boolean isLiked;

	public TrackDTO(Track track) {
		this.trackSpotifyId = track.getTrackSpotifyId();
		this.name = track.getName();
		this.artist = new ArtistDTO(track.getArtist());
		this.previewURL = track.getPreviewURL();
		this.imageURL = track.getImageURL();
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

	public ArtistDTO getArtist() {
		return artist;
	}

	public void setArtist(ArtistDTO artist) {
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

	public boolean isLiked() {
		return isLiked;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	
}
