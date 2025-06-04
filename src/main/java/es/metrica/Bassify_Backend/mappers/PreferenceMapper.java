package es.metrica.Bassify_Backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.metrica.Bassify_Backend.models.dto.WeightedPreferenceDTO;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;

@Mapper
public interface PreferenceMapper {

	PreferenceMapper INSTANCE = Mappers.getMapper(PreferenceMapper.class);
	
	WeightedPreference weightedPreferenceDtoToWeightedPreference(WeightedPreferenceDTO weightedPreferenceDto);
	WeightedPreferenceDTO weightedPreferenceToWeightedPreferenceDto(WeightedPreference weightedPreference);
	
}
