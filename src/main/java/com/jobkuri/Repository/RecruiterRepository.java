package com.jobkuri.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobkuri.Entity.Recruiter;



@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    Optional<Recruiter> findByRecruiterEmail(String recruiterEmail);

    Optional<Recruiter> findByCompanyName(String companyName);

}

