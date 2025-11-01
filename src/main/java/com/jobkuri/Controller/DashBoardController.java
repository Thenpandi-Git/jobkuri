package com.jobkuri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobkuri.DTO.ApplicationStatusDTO;
import com.jobkuri.DTO.JobPostStatusDTO;
import com.jobkuri.DTO.UserStatusDTO;
import com.jobkuri.Service.DashBoardService;


@RestController
@RequestMapping("/api/dashBoards")
public class DashBoardController {
	
	@Autowired
	private DashBoardService dashBoardService;
	
	
	@GetMapping("/jobs")
	public ResponseEntity<JobPostStatusDTO>fetchJobs(){
		return ResponseEntity.ok(dashBoardService.fetchJobStatus());
	}

	@GetMapping("/applications")
	public ResponseEntity<ApplicationStatusDTO>fetchApplication(){
		return ResponseEntity.ok(dashBoardService.fetchApplicationStatus());
	}
	
	@GetMapping("/users")
	public ResponseEntity<UserStatusDTO>fetchUsers(){
		return ResponseEntity.ok(dashBoardService.fetchUsersStatus());
	}
}
