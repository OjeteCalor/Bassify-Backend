package es.metrica.Bassify_Backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.metrica.Bassify_Backend.models.entity.Artist;
import es.metrica.Bassify_Backend.models.entity.Track;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@GetMapping("/login")
	public ResponseEntity<Track> startSession(){
		//Track track = new Track(1, "Zapatillas", new Artist("Dani Martín"));
		//return ResponseEntity.ok(track);
		return null;
	}
	
}
