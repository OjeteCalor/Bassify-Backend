package es.metrica.Bassify_Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.metrica.Bassify_Backend.models.entity.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findBySpotifyId(String spotifyId);
	/*
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

	*/
}
