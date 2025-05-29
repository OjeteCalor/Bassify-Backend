package es.metrica.Bassify_Backend.services.imp;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.repository.UserRepository;
import es.metrica.Bassify_Backend.services.UserService;

public class UserServiceImp implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public ResponseEntity<Void> login(UserDTO userDto) {
		return userRepository.findById(userDto.getSpotifyId()) 
				? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public Optional<UserDTO> createPreference(UserDTO userDto) {
		return userRepository.save(userDto);
	}

}
