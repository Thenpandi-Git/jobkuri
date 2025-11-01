package com.jobkuri.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.JobPost;



@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {
	
	List<JobPost>findByRecruiterEmail(String recruiterEmail);
	List<JobPost>findByJobTitle(String jobTitle);
	List<JobPost>findByCompanyName(String comapanyName);
	
	 int countByJobType(String jobType);
		

}
