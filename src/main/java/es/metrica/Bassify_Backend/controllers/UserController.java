package es.metrica.Bassify_Backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.services.UserService;
import es.metrica.Bassify_Backend.services.imp.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService = new UserServiceImp();
	
	@GetMapping("path")
	public String getMethodName(@RequestParam Track track) {
		
		return new String();
	}
	
	@PostMapping("/create")
	public User create(@RequestBody UserDTO userDto) {
		return userService.create(userDto);
	}
	
}
