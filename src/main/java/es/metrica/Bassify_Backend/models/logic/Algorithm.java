package es.metrica.Bassify_Backend.models.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import es.metrica.Bassify_Backend.models.entity.Track;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;

public class Algorithm {
	private static final int DEFAULT_QUANTITY = 20;
	
	public static List<Track> getTracks(Set<WeightedPreference> preferences){
		return getTracks(preferences, DEFAULT_QUANTITY);
	}
	
	public static List<Track> getTracks(Set<WeightedPreference> preferences, int quantity){
		List<Track> tracks = new LinkedList<>();
		for(WeightedPreference pref : preferences) {
			tracks.addAll(new TrackRequest().getTrackResponse(
					pref.getGenre(),
					pref.getLikedSongsCount().intValue() / pref.getListenedSongCount().intValue(),
					pref.getListenedSongCount().intValue()
				));
		}
		return tracks;
	}
}

