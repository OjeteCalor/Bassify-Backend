package es.metrica.Bassify_Backend.services;

import java.util.Arrays; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.metrica.Bassify_Backend.mappers.TrackMapper;
import es.metrica.Bassify_Backend.mappers.UserMapper;
import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;
import es.metrica.Bassify_Backend.models.logic.Algorithm;
import es.metrica.Bassify_Backend.models.values.Genre;
import es.metrica.Bassify_Backend.repository.TrackRepository;
import es.metrica.Bassify_Backend.repository.UserRepository;

@Service
public class TrackServiceimp implements TrackService {

	private final Logger LOG = LoggerFactory.getLogger(TrackServiceimp.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrackRepository trackRepository;
	
	private UserMapper userMapper = UserMapper.INSTANCE;
	private TrackMapper trackMapper = TrackMapper.INSTANCE;
	
	@Override
	public ResponseEntity<List<TrackDTO>> discoverRandom() {
		return new ResponseEntity<>(Algorithm.getRandomTracks(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TrackDTO>> discoverPreferences(String spotifyId) {
		
		Optional<User> userOpt = userRepository.findBySpotifyId(spotifyId);
		
		if(!userOpt.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		UserDTO userDto = userMapper.userToUserDto(userOpt.get());
		return new ResponseEntity<>(Algorithm.getTracks(userDto.getPreferences()), HttpStatus.OK);	
	}

	@Override
	public ResponseEntity<Void> discoverListened(String spotifyId, List<TrackDTO> trackListListened) {

		Optional<User> userOpt = userRepository.findBySpotifyId(spotifyId);
			
		if(!userOpt.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<Track> trackList = trackListListened.stream().map(t -> trackMapper.trackDTOtoTrack(t)).toList();
		trackRepository.saveAll(trackList);
		
		User user = userOpt.get();
		user.getListenedTracks().addAll(trackList);
				
		for(TrackDTO trackDto : trackListListened) {

			List<String> genresRegisteredByUser = user.getPreferences().stream().map(p -> p.getGenre()).toList();
			
			for(String genre : trackDto.getArtist().getGenres()) {
				
				WeightedPreference w;				
				if(genresRegisteredByUser.contains(genre)) {					
					w = user.getPreferences().stream()
												.filter(g -> g.getGenre().equals(genre))
												.findFirst()
												.orElseThrow();
					
					if(trackDto.isLiked())
						w.setLikedTracksCount(w.getLikedTracksCount()+1);
					w.setListenedTracksCount(w.getListenedTracksCount()+1);	
					
				} else {				
					w = new WeightedPreference(null, genre, 0L, 0L, user);
					
					if(trackDto.isLiked())
						w.setLikedTracksCount(w.getLikedTracksCount()+1);					
					w.setListenedTracksCount(w.getListenedTracksCount()+1);
					
					user.getPreferences().add(w);
				}				
			}				
		}		
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> genres() {
		Map<String, Object> map = new HashMap<>();
		List<String> genres = Arrays.stream(Genre.values())
									.map(Object::toString)
									.toList();
		map.put("genres", genres);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> initializePreferences(String spotifyId, List<String> genres) {
		
		Optional<User> userOpt = userRepository.findBySpotifyId(spotifyId);
		
		if(!userOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User user = userOpt.get();
		
		Set<WeightedPreference> weightedPreferenceSet = new HashSet<>();
		for(String genre : genres) {
			WeightedPreference w = new WeightedPreference(null, genre, 0L, 0L, user);
			weightedPreferenceSet.add(w);
		}
		user.addPreferences(weightedPreferenceSet);
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
	