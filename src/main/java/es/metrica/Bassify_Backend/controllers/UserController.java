package es.metrica.Bassify_Backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.dto.UserLoginDTO;
import es.metrica.Bassify_Backend.services.UserService;

@RestController
@RequestMapping("/api/v1/account")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ResponseEntity<UserLoginDTO> login(@RequestBody UserDTO userDto){
		return userService.login(userDto);
	}
	
	@PostMapping("/create/preferences")
	public ResponseEntity<UserDTO> createPreferences(@RequestBody UserDTO userDto){
		 return userService.createPreference(userDto);
	}
	
}