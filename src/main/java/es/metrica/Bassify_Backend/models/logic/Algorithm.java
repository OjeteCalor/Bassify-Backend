package es.metrica.Bassify_Backend.models.logic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.dto.WeightedPreferenceDTO;
import es.metrica.Bassify_Backend.models.values.Genre;

public class Algorithm {
	
	private static final int DEFAULT_QUANTITY = 20;
	private static final Set<WeightedPreferenceDTO> DEFAULT_PREFERENCES = new java.util.HashSet<>() {
		{
		for(Genre genre : Genre.values())
			add(new WeightedPreferenceDTO(genre.toString()));
		}
	};
	
	public static List<TrackDTO> getRandomTracks(){
		List<TrackDTO> tracks = new java.util.LinkedList<>();
		for (SearchQuery q : createQuerys(DEFAULT_PREFERENCES, DEFAULT_QUANTITY)) {
			tracks.addAll(new TrackRequest().getTracks(
					q.genre,
					q.limit.intValue(),
					new Random().nextInt(0, 1000)
				));
		}
		return tracks;
	}
	
	public static List<TrackDTO> getTracks(){
		return getTracks(DEFAULT_PREFERENCES, DEFAULT_QUANTITY);
	}
	
	public static List<TrackDTO> getTracks(Set<WeightedPreferenceDTO> preferences){
		return getTracks(preferences, DEFAULT_QUANTITY);
	}
	
	public static List<TrackDTO> getTracks(Set<WeightedPreferenceDTO> preferences, int quantity){
		if (preferences.size() == 0)
			return getRandomTracks();
		List<TrackDTO> tracks = new java.util.LinkedList<>();
		for (SearchQuery q : createQuerys(preferences, quantity)) {
			
			tracks.addAll(new TrackRequest().getTracks(
					q.genre,
					q.limit.intValue(),
					q.offset.intValue()
				));
		}
		return tracks;
	}
	
	private static List<SearchQuery> createQuerys(Set<WeightedPreferenceDTO> preferences, int maxWeight) {
		List<SearchQuery> querys = new java.util.LinkedList<>();
		double total = preferences.stream()
				.mapToDouble((p) -> (double) p.getLikedTracksCount() / (double) p.getListenedTracksCount())
				.sum();
		long totalWeight = 0;
		for(WeightedPreferenceDTO pref : preferences) {
			double weight = (double) pref.getLikedTracksCount() / (double) pref.getListenedTracksCount()
					/total*maxWeight;
			totalWeight += weight;
			if (weight >= 1)
				querys.addLast(new SearchQuery(pref.getGenre(),(long) weight,pref.getListenedTracksCount()));
		}
		if ((long) totalWeight != maxWeight) {
			int randIdx = new Random().nextInt(0, querys.size());
			querys.get(randIdx).setLimit((long)(querys.get(randIdx).getLimit() + maxWeight - totalWeight));
		}
			
		return querys;
	}

}
class SearchQuery {
	String genre;
	Long limit;
	Long offset;
	public SearchQuery(String genre, Long limit, Long offset) {
		super();
		this.genre = genre;
		this.limit = limit;
		this.offset = offset;
	}
	public Long getLimit() {
		return limit;
	}
	public void setLimit(Long limit) {
		this.limit = limit;
	}
}
