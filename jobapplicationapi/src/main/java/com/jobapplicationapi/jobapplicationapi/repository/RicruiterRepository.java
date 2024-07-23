package com.jobapplicationapi.jobapplicationapi.repository;

import com.jobapplicationapi.jobapplicationapi.users.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicruiterRepository extends JpaRepository<Recruiter, Long> {
}
