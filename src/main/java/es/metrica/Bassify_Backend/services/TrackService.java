package es.metrica.Bassify_Backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;

public interface TrackService {
	ResponseEntity<List<TrackDTO>> discoverRandom(String spotifyId);
}
