package es.metrica.Bassify_Backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.metrica.Bassify_Backend.models.dto.TrackDTO;
import es.metrica.Bassify_Backend.models.entity.Track;

@Mapper
public interface TrackMapper {
	
	TrackMapper INSTANCE = Mappers.getMapper(TrackMapper.class); // ?
	
	public Track trackDTOtoTrack(TrackDTO trackDto);
	public TrackDTO trackToTrackDTO(Track track);
	
}
