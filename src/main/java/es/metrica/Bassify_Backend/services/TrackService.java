package es.metrica.Bassify_Backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;

public interface TrackService {
	ResponseEntity<List<TrackDTO>> discoverRandom();
	ResponseEntity<List<TrackDTO>> discoverPreferences(String spotifyId);
	ResponseEntity<List<TrackDTO>> discoverListened(String spotifyId, List<TrackDTO> trackListListened);
	ResponseEntity<List<TrackDTO>> genres();
}
