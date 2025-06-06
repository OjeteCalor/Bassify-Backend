package es.metrica.Bassify_Backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.entity.User;

public interface TrackService {
	ResponseEntity<List<TrackDTO>> discoverRandom();
	ResponseEntity<List<TrackDTO>> discoverPreferences(String spotifyId);
	ResponseEntity<Void> discoverListened(String spotifyId, List<TrackDTO> trackListListened);
	ResponseEntity<Map<String, Object>> genres();
	ResponseEntity<Void> initializePreferences(String spotifyId, List<String> genres);
}
