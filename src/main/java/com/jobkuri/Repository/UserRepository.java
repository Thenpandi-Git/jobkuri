package com.jobkuri.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.User;




@Repository

public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User>findByEmail(String email);
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	

}
