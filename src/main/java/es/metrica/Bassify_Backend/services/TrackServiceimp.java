package es.metrica.Bassify_Backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.repository.TrackRepository;
import es.metrica.Bassify_Backend.repository.UserRepository;

@Service
public class TrackServiceimp implements TrackService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TrackRepository trackRepository;

	@Override
	public ResponseEntity<List<TrackDTO>> discoverRandom(String userSpotifyId) {
		Optional<User> user = userRepository.findBySpotifyId(userSpotifyId);
		
		if(user.isPresent()) {
			// TODO
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
}
