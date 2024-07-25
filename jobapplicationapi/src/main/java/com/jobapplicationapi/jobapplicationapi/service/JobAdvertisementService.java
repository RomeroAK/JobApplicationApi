package com.jobapplicationapi.jobapplicationapi.service;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.entities.Recruiter;

import java.util.List;
import java.util.Optional;

public interface JobAdvertisementService {

    List<JobAdvertisements> getAllJobAdvertisements();
    List<JobAdvertisements> getJobAdvertByRecruiterId(Long id);
    Optional<JobAdvertisements> getAJobAdvertisementById(Long id);
    JobAdvertisements updateJobInfo(JobAdvertisements jobAdvertisements);
    JobAdvertisements uploadJobAvertisemet(JobAdvertisements jobAdvertisements);
    void deleteJobAdvertisement(Long id);


}
