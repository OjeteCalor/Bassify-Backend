package es.metrica.Bassify_Backend.repository;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.metrica.Bassify_Backend.models.dto.UserDTO;

@Repository
public class UserRepository {

	public Optional<UserDTO> findById(String id) {
		// Verificar si se encuentra en la BBDD, si no se ecnuentra DEBE CREARSE
		// .save() / .create()
		// User user = findById(id);
		UserDTO userDto = new UserDTO();
		userDto.setSpotifyId(id);
		userDto.setListenedTracks(new HashSet<>());
		userDto.setPreferences(new HashSet<>());
		return Optional.of(userDto);
	}
	
	public Optional<UserDTO> save(UserDTO userDto) {
		// Guardar el userDto en la base de datos
		return null;
	}
	
}
