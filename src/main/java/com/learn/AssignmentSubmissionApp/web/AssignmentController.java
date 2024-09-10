package com.learn.AssignmentSubmissionApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.AssignmentSubmissionApp.domain.Assignment;
import com.learn.AssignmentSubmissionApp.domain.User;
import com.learn.AssignmentSubmissionApp.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@PostMapping("")
	public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
		Assignment newAssignment = assignmentService.save(user);
		return ResponseEntity.ok(newAssignment);
	}
	
	@GetMapping("")
	public ResponseEntity<?> findByUser(@AuthenticationPrincipal User user){
		List<Assignment> assignmentsByUser = assignmentService.findByUser(user);
		return ResponseEntity.ok(assignmentsByUser);
	}
	
	@GetMapping("{assignmentId}")
	public ResponseEntity<?> getOneAssignmentByUser(@PathVariable Long assignmentId, @AuthenticationPrincipal User user){
		Optional<Assignment> assignment = assignmentService.getOneById(assignmentId);
		return ResponseEntity.ok(assignment.orElse(new Assignment()));
	}
	
	@PutMapping("{assignmentId}")
	public ResponseEntity<?> updateAssignment(@PathVariable Long assignmentId, @AuthenticationPrincipal User user, @RequestBody Assignment assignment){
		Assignment updatedAssignment = assignmentService.save(assignment);
		return ResponseEntity.ok(updatedAssignment);
		
	}

}
