package com.jobapplicationapi.jobapplicationapi.repository;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisements, Long> {
    List<JobAdvertisements> getJobAdvertByRecruiterId(Long recruiterId);
}
