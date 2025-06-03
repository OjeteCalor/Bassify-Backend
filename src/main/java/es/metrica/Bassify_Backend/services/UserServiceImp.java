package es.metrica.Bassify_Backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.models.logic.toolbox.TokenPetition;
import es.metrica.Bassify_Backend.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<UserDTO> login(UserDTO userDto) {
		String accessToken = AccesToken.getAccessToken(userDto.getRefreshToken());
		String spotifyId = TokenPetition.getUserId(accessToken);
		userDto.setSpotifyId(spotifyId);
		Optional<User> userOpt = userRepository.findBySpotifyId(userDto.getSpotifyId());

		// Si ya está registrado
		if(userOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			User user = userRepository.save(new User(userDto));
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
		}

	}

	@Override
	public ResponseEntity<UserDTO> createPreference(UserDTO userDto) {
		Optional<User> userOpt = userRepository.findBySpotifyId(userDto.getSpotifyId());
		
		// Si ya está registrado
//		if(userOpt.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		} else {
//			User user = userRepository.save(new User(userDto));
//			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
//		}
		return null;
	}

}
