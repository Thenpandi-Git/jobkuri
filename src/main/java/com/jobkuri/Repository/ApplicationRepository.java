package com.jobkuri.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.Application;
import com.jobkuri.Enum.JobType; 

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
   
    Optional<Application> findByJobSeekerEmailAndJobId(String jobSeekerEmail, Long jobId);
  
    List<Application> findByJobSeekerEmail(String jobSeekerEmail);
    List<Application> findByRecruiterEmail(String recruiterEmail);
    List<Application> findByJobTitle(String jobTitle);
    List<Application> findByJobType(JobType jobType);
    
    int countByStatus(String Status);
}
