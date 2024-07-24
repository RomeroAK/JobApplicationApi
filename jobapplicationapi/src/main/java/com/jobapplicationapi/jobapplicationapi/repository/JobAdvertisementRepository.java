package com.jobapplicationapi.jobapplicationapi.repository;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisements, Long> {
}
