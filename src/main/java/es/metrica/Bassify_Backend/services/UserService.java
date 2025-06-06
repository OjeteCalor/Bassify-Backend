package es.metrica.Bassify_Backend.services;

import org.springframework.http.ResponseEntity; 

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.dto.UserLoginDTO;

public interface UserService {
	public ResponseEntity<UserLoginDTO> login(UserDTO userDto);
	public ResponseEntity<Void> createPreference(UserDTO userDto);
}
