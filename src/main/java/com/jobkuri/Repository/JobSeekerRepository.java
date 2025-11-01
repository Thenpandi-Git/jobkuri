package com.jobkuri.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.JobSeeker;



@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Long> {
	
	Optional<JobSeeker>findByEmail(String email);

}
