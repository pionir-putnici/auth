package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.User;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
	@Query ( "from User c " + 
			"inner join c.roles as e " + 
			"where c.username =  :username")
	
	User findUserWithRoles(String username);
}
