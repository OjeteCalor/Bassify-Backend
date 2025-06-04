package es.metrica.Bassify_Backend.models.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.dto.WeightedPreferenceDTO;
import es.metrica.Bassify_Backend.models.values.Genre;

public class Algorithm {
	private static final int DEFAULT_QUANTITY = 20;
	private static final Set<WeightedPreferenceDTO> DEFAULT_PREFERENCES= new java.util.HashSet<>() {{
		for(Genre genre : Genre.values())
			add(new WeightedPreferenceDTO(genre.toString()));
	}};
	
	public static List<TrackDTO> getTracks(){
		return getTracks(DEFAULT_PREFERENCES, DEFAULT_QUANTITY);
	}
	
	public static List<TrackDTO> getTracks(Set<WeightedPreferenceDTO> preferences){
		return getTracks(preferences, DEFAULT_QUANTITY);
	}
	
	public static List<TrackDTO> getTracks(Set<WeightedPreferenceDTO> preferences, int quantity){
		List<TrackDTO> tracks = new LinkedList<>();
		for(WeightedPreferenceDTO pref : preferences) {
			tracks.addAll(new TrackRequest().getTracks(
					pref.getGenre(),
					pref.getLikedTracksCount().intValue() / pref.getListenedTracksCount().intValue(),
					pref.getListenedTracksCount().intValue()
				));
		}
		return tracks;
	}
}

