package es.metrica.Bassify_Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.services.TrackService;

@Controller
@RequestMapping("api/v1/tracks")
public class TrackController {

	@Autowired
	private TrackService trackService;
	
	@PostMapping("track/discover/random/{spotifyId}")
	public ResponseEntity<List<TrackDTO>> discoverRandom(@PathVariable String spotifyId){
		return trackService.discoverRandom(spotifyId);
	}
	
}
