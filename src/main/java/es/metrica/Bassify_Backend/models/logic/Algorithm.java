package es.metrica.Bassify_Backend.models.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;

public class Algorithm {
	private static final int DEFAULT_QUANTITY = 20;
	
	public static List<TrackDTO> getTracks(Set<WeightedPreference> preferences){
		return getTracks(preferences, DEFAULT_QUANTITY);
	}
	
	public static List<TrackDTO> getTracks(Set<WeightedPreference> preferences, int quantity){
//		List<Track> tracks = new LinkedList<>();
//		for(WeightedPreference pref : preferences) {
//			tracks.addAll(new TrackRequest().getTrackResponse(
//					pref.getGenre(),
//					pref.getLikedTracksCount().intValue() / pref.getListenedTracksCount().intValue(),
//					pref.getListenedTracksCount().intValue()
//				));
//		}
//		return tracks;
		return null;
	}
}

