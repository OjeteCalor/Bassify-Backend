package es.metrica.Bassify_Backend.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.services.TrackService;

@Controller
@RequestMapping("api/v1/tracks")
public class TrackController {

	private final Logger LOG = LoggerFactory.getLogger(TrackController.class);
	
	@Autowired
	private TrackService trackService;
	
	@GetMapping("/discover/random")
	public ResponseEntity<List<TrackDTO>> discoverRandom(){
		return trackService.discoverRandom();
	}
	
	@GetMapping("/discover/preferences/{user_id}")
	public ResponseEntity<List<TrackDTO>> discoverPreferences(@PathVariable(name = "user_id") String spotifyId){
		return trackService.discoverPreferences(spotifyId);
	}
	
	@PostMapping("/discover/listened/{user_id}")
	public ResponseEntity<Void> discoverListened(@PathVariable(name = "user_id") String spotifyId, 
																@RequestBody List<TrackDTO> trackListListened){
		return trackService.discoverListened(spotifyId, trackListListened);
	}
	
	@GetMapping("/genres")
	public ResponseEntity<Map<String, Object>> genres(){
		return trackService.genres();
	}
	
	@PostMapping("/initialize/{user_id}")
	public ResponseEntity<Void> initializePreferences(@PathVariable(name = "user_id") String spotifyId, 
																@RequestBody List<String> genres) {
		return trackService.initializePreferences(spotifyId, genres);
	}
	
}
