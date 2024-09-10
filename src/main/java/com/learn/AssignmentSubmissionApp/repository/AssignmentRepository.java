package com.learn.AssignmentSubmissionApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.AssignmentSubmissionApp.domain.Assignment;
import com.learn.AssignmentSubmissionApp.domain.User;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
	
	public List<Assignment> findByUser(User user);

}
