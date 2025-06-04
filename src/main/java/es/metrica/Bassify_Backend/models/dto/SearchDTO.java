package es.metrica.Bassify_Backend.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchDTO {
	private Tracks tracks;

	public Tracks getTracks() {
		return tracks;
	}

	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "SearchDTO [tracks=" + tracks + "]";
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Tracks {
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Tracks [items=" + items + "]";
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Item {
	@Override
	public String toString() {
		return "Item [album=" + album + ", artists=" + artists + ", id=" + id + ", name=" + name + "]";
	}

	private Album album;
	private List<Artist> artists;
	private String id;
	private String name;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Album {

	private List<Image> images;

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Artist {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Image {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}