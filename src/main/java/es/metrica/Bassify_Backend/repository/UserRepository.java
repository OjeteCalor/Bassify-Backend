package es.metrica.Bassify_Backend.repository;

import java.util.Optional;

import es.metrica.Bassify_Backend.models.dto.UserDTO;

public class UserRepository {
	
	public Boolean findById(String id) {
		// Verificar si se encuentra en la BBDD, si no se ecnuentra DEBE CREARSE
		// .save() / .create()
		return null;
	}
	
	public Optional<UserDTO> save(UserDTO userDto) {
		// Guardar el userDto en la base de datos
		return null;
	}
	
}
