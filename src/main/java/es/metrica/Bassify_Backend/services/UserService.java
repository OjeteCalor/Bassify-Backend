package es.metrica.Bassify_Backend.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import es.metrica.Bassify_Backend.models.dto.UserDTO;

public interface UserService {
	public ResponseEntity<UserDTO> login(UserDTO userDto);
	public Optional<UserDTO> createPreference(UserDTO userDto);
}
