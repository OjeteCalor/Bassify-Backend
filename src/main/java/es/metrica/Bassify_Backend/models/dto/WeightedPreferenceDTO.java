package es.metrica.Bassify_Backend.models.dto;

public class WeightedPreferenceDTO {
	
	private String genre;
	private Long likedTracksCount;
	private Long listenedTracksCount;
	private UserDTO userDto;
	
	public WeightedPreferenceDTO() {}

	public WeightedPreferenceDTO(String genre) {
		this(genre, 1l, 1l);
	}
	
	public WeightedPreferenceDTO(String genre, Long likedTracksCount, Long listenedTracksCount) {
		super();
		this.genre = genre;
		this.likedTracksCount = likedTracksCount;
		this.listenedTracksCount = listenedTracksCount;
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

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	
}
