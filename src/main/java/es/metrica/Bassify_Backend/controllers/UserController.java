package es.metrica.Bassify_Backend.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.metrica.Bassify_Backend.models.Track;

@Controller
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/login")
	@ResponseBody
	public ResponseEntity<Track> startSession(@RequestBody Requ){
		return null;
	}
	
}
