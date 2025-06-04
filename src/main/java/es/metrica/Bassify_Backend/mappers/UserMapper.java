package es.metrica.Bassify_Backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.dto.UserLoginDTO;
import es.metrica.Bassify_Backend.models.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User userDtoToUser(UserDTO userDto);
	UserLoginDTO userToUserLoginDto(User user);
	UserDTO userToUserDto(User user);
	
}
