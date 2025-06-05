package es.metrica.Bassify_Backend.services;

import java.util.Optional; 
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.mappers.UserMapper;
import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.dto.UserLoginDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;
import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.models.logic.toolbox.TokenPetition;
import es.metrica.Bassify_Backend.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	private UserMapper userMapper = UserMapper.INSTANCE;
		
	@Override
	public ResponseEntity<UserLoginDTO> login(UserDTO userDto) { 
		
		String accessToken = AccesToken.getAccessToken(userDto.getRefreshToken());
		String spotifyId = TokenPetition.getUserId(accessToken);
		userDto.setSpotifyId(spotifyId);
		
		Optional<User> userOpt = userRepository.findBySpotifyId(userDto.getSpotifyId());

		if(userOpt.isPresent()) {
			User user = userRepository.findBySpotifyId(userDto.getSpotifyId()).get();
			return new ResponseEntity<>(userMapper.userToUserLoginDto(user), HttpStatus.OK);
		} else {
			User user = userRepository.save(userMapper.userDtoToUser(userDto));
			return new ResponseEntity<>(userMapper.userToUserLoginDto(user), HttpStatus.CREATED);
		}

	}

	@Override
	public ResponseEntity<Void> createPreference(UserDTO userDto) {
		
		Optional<User> userOpt = userRepository.findBySpotifyId(userDto.getSpotifyId());
		
		if(!userOpt.isPresent()) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
		User user = userOpt.get();
		Set<WeightedPreference> preferencesSet = userDto.getPreferences().stream()
																		.map(p -> new WeightedPreference(null, p.getGenre(), p.getLikedTracksCount(), p.getListenedTracksCount(), user))
																		.collect(Collectors.toSet());
		
		user.addPreferences(preferencesSet);

		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
