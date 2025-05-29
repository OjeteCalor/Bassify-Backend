package es.metrica.Bassify_Backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public ResponseEntity<Void> login(@RequestBody UserDTO userDto){
		return userService.login(userDto);
	}
	
	@PostMapping("/create/preferences")
	public ResponseEntity<UserDTO> createPreferences(@RequestBody UserDTO userDto){
		return userService.createPreference(userDto).get() != null 
				? new ResponseEntity<>(userDto, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
