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
		Optional<User> userFoundCreated = userRepository.findBySpotifyId(userDto.getSpotifyId());
		return userFoundCreated.isPresent()
				? new ResponseEntity<>(new UserDTO(userFoundCreated.get()), HttpStatus.CREATED)
						: new ResponseEntity(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDTO> createPreference(UserDTO userDto) {
		Optional<User> userOpt = userRepository.findBySpotifyId(userDto.getSpotifyId());
		
		// Si ya está registrado
		if(userOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			User user = userRepository.save(new User(userDto));
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
		}
		
	}

}
