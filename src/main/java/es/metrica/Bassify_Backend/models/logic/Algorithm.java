package es.metrica.Bassify_Backend.models.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.dto.WeightedPreferenceDTO;

public class Algorithm {
	private static final int DEFAULT_QUANTITY = 20;
	
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

