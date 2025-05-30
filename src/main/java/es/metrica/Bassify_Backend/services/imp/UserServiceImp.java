package es.metrica.Bassify_Backend.services.imp;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.repository.UserRepository;
import es.metrica.Bassify_Backend.services.UserService;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public ResponseEntity<UserDTO> login(UserDTO userDto) {
		UserDTO userFoundCreated = userRepository.findById(userDto.getSpotifyId()).orElse(null);
		return userFoundCreated == null
				? new ResponseEntity(HttpStatus.OK)
						: new ResponseEntity<>(userFoundCreated, HttpStatus.CREATED);
	}

	@Override
	public Optional<UserDTO> createPreference(UserDTO userDto) {
		return userRepository.save(userDto);
	}

}
