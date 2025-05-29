package es.metrica.Bassify_Backend.services.imp;

import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.services.UserService;

public class UserServiceImp implements UserService {

	@Override
	public User create(UserDTO userDto) {
		// TODO
		User user = new User();
		user.setUserId(userDto.getId());
		user.setListened(userDto.getListened());
		user.setPreferences(userDto.getPreferences());
		return user;
	}

}
