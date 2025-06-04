package es.metrica.Bassify_Backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.models.logic.Algorithm;
import es.metrica.Bassify_Backend.repository.TrackRepository;
import es.metrica.Bassify_Backend.repository.UserRepository;

@Service
public class TrackServiceimp implements TrackService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<List<TrackDTO>> discoverRandom() {
		return new ResponseEntity<>(Algorithm.getTracks(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TrackDTO>> discoverPreferences(String spotifyId) {
		Optional<User> user = userRepository.findBySpotifyId(spotifyId);
		
		if(user.isPresent()) {
			UserDTO userDto = new UserDTO(user.get());
			return new ResponseEntity<List<TrackDTO>>(Algorithm.getTracks(userDto.getPreferences()),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<TrackDTO>> discoverListened(String spotifyId, List<TrackDTO> trackListListened) {
		Optional<User> userOpt = userRepository.findBySpotifyId(spotifyId);
		
		if(!userOpt.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		User user = userOpt.get();
//		user.getListenedTracks().add(new HashSet<TrackDTO>(trackListListened));	
		return null;
	}

	@Override
	public ResponseEntity<List<TrackDTO>> genres() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
