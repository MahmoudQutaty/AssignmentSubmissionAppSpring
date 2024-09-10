package com.learn.AssignmentSubmissionApp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.AssignmentSubmissionApp.domain.Assignment;
import com.learn.AssignmentSubmissionApp.domain.User;
import com.learn.AssignmentSubmissionApp.repository.AssignmentRepository;

@Service
public class AssignmentService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	public Assignment save(User user) {
		Assignment assignment = new Assignment();
		assignment.setStatus("Needs to be submitted");
		assignment.setUser(user);
		return assignmentRepository.save(assignment);
	}
	
	public List<Assignment> findByUser(User user){
		return assignmentRepository.findByUser(user);
	}
	
	public Optional<Assignment> getOneById(Long assignmentId) {
		return assignmentRepository.findById(assignmentId);
	}

	public Assignment save(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

}
	