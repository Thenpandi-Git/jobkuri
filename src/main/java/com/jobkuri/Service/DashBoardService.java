package com.jobkuri.Service;

import org.springframework.stereotype.Service;

import com.jobkuri.DTO.ApplicationStatusDTO;
import com.jobkuri.DTO.JobPostStatusDTO;
import com.jobkuri.DTO.UserStatusDTO;

@Service
public class DashBoardService {
	
	
	public JobPostStatusDTO fetchJobStatus() {
		JobPostStatusDTO jobs = new JobPostStatusDTO();
			
			jobs.setTotalJobs(120);
			jobs.setTotalInternships(60);
			jobs.setTotalExperience(50);
			jobs.setTotalPartTimeJobs(70);
			jobs.setTotalFullTimeJobs(40);
			jobs.setTotalContractualJobs(50);
			jobs.setTotalFreelanceJobs(30);
			
			return jobs;
		
	}
	
	
	
	public ApplicationStatusDTO fetchApplicationStatus() {
		
		ApplicationStatusDTO applicant = new ApplicationStatusDTO();
		
		applicant.setTotalApplications(500);
		applicant.setTotalShortlisted(100);
		applicant.setTotalRejected(150);
		applicant.setTotalPending(200);
		
		return applicant;
		
	}
	
	public UserStatusDTO fetchUsersStatus() {
		
		UserStatusDTO users = new UserStatusDTO();
		
		users.setTotalJobseekers(10000);
		users.setTotalRecruiters(500);
		users.setTotalBlockUsers(1000);
		users.setTotalPaidUsers(500);
		
		return users;
	}

}

