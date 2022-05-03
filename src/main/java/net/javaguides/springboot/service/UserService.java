package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

//	User update(UserRegistrationDto registrationDto);
	List<User> allUser();
	void saveUserById(User user);
	User getUserById(long id);
	void deleteUserById(long id);
	User getUserByEmail(String email);
//	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<User> findByEmail(String email);
}
