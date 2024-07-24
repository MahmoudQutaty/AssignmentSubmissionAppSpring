package com.learn.AssignmentSubmissionApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.learn.AssignmentSubmissionApp.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);

}
