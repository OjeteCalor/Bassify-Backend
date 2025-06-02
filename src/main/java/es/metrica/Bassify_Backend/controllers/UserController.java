package es.metrica.Bassify_Backend.controllers;

import java.util.HashMap;
import java.util.Map;

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
@RequestMapping("/api/v1/account")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto){
		return userService.login(userDto);
	}
	
	@PostMapping("/create/preferences")
	public Map<String, Object> createPreferences(@RequestBody UserDTO userDto){
		// return userService.createPreference(userDto);
		ResponseEntity<UserDTO> responseDto = userService.createPreference(userDto);
		Map<String, Object> map = new HashMap<>();
		map.put("status", responseDto.getStatusCodeValue());
		map.put("is_new", responseDto.getStatusCode() == HttpStatus.CREATED);
		map.put("created_user", responseDto.getBody());
		return map;
	}
	
}