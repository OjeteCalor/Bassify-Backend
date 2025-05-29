package es.metrica.Bassify_Backend.models.logic.toolbox;

import com.fasterxml.jackson.databind.JsonNode;

import es.metrica.Bassify_Backend.models.entity.Artist;
import es.metrica.Bassify_Backend.models.entity.Track;

public class JsonParser {
	public static Track parseTrack(JsonNode json) {
		Track track = new Track();
		
		track.setName(json.get("name").textValue());
		track.setSpotifyId(json.get("id").textValue());
		track.setImageURL(json.get("album").withArrayProperty("images").get(0).get("url").asText());
		track.setArtist(parseArtist(json.get("artist")));
		
		return track;
	}
	
	public static Artist parseArtist(JsonNode json) {
		Artist artist = new Artist();
		
		artist.setSpotifyId(json.get("id").textValue());
		
		return artist;
	}
}
