package com.jobapplicationapi.jobapplicationapi.repository;


import com.jobapplicationapi.jobapplicationapi.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Long> {


}
