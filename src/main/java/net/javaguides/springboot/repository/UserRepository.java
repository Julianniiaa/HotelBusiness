package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT p FROM User p WHERE p.firstName LIKE %?1%"
			+ " OR p.lastName LIKE %?1%"
			+ " OR p.email LIKE %?1%")
	List<User> findByEmailAndFirstNameAndLastName(String keyword);
	User findByEmail(String email);
}
