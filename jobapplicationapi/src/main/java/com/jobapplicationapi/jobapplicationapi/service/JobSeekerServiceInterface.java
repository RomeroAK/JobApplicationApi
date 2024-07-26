package com.jobapplicationapi.jobapplicationapi.service;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.entities.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobSeekerServiceInterface {

    JobSeeker saveJobSeeker(JobSeeker jobSeeker);
    JobSeeker updateJobSeeker(JobSeeker jobSeeker);
    void deleteJobSeeker(Long Id);
    Optional<JobSeeker> getJobSeekerById(Long Id);
    List<JobSeeker> getAllJobSeekers();
    boolean applyToJob(Long jobSeekerId, JobAdvertisements jobVacany);
    boolean cancelApplication(Long jobSeekerId, JobAdvertisements jobVacancy);
}
