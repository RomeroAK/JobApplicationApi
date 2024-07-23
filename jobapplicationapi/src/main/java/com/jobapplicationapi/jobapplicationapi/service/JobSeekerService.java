package com.jobapplicationapi.jobapplicationapi.service;

import com.jobapplicationapi.jobapplicationapi.repository.JobSeekerRepository;
import com.jobapplicationapi.jobapplicationapi.users.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService implements JobSeekerServiceInterface {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;


    @Override
    public JobSeeker saveJobSeeker(JobSeeker jobSeeker){
        return jobSeekerRepository.save(jobSeeker);
    }


    @Override
    public JobSeeker updateJobSeeker(JobSeeker jobSeeker) {
        Optional<JobSeeker> jobSeeker1 = jobSeekerRepository.findById(jobSeeker.getId());
        if(jobSeeker1.isPresent()){
            JobSeeker existingJobSeeker = jobSeeker1.get();
            existingJobSeeker.setName(jobSeeker.getName());
            existingJobSeeker.setGender(jobSeeker.getGender());
            return jobSeekerRepository.save(existingJobSeeker);

        } else {
            throw new RuntimeException("JobSeeker with "+jobSeeker.getId()+" is not found");
        }
    }


    @Override
    public void deleteJobSeeker(Long Id) {
        jobSeekerRepository.deleteById(Id);
    }

    @Override
    public Optional<JobSeeker> getJobSeekerById(Long Id) {
        return jobSeekerRepository.findById(Id);
    }

    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

}
