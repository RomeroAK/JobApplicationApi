package com.jobapplicationapi.jobapplicationapi.service;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.repository.JobAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobadvertisementServiceImp implements JobAdvertisementService{

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Override
    public List<JobAdvertisements> getAllJobAdvertisements() {
        return jobAdvertisementRepository.findAll();
    }

    @Override
    public Optional<JobAdvertisements> getAJobAdvertisementById(Long id) {
        return jobAdvertisementRepository.findById(id);
    }

    @Override
    public JobAdvertisements updateJobInfo(JobAdvertisements jobAdvertisements) {
        Optional<JobAdvertisements> updateJobVacancy = jobAdvertisementRepository.findById(jobAdvertisements.getJobId());
        if(updateJobVacancy.isPresent()){
            JobAdvertisements jba1 = updateJobVacancy.get();
            jba1.setSalary(jobAdvertisements.getSalary());
            jba1.setVacancyTitle(jobAdvertisements.getVacancyTitle());
            jba1.setStartDate(jobAdvertisements.getStartDate());
            jba1.setApplicationCloseDate(jobAdvertisements.getApplicationCloseDate());
            return jobAdvertisementRepository.save(jba1);
        } else {
            throw new RuntimeException("JobAdvert with ID "+jobAdvertisements.getJobId()+" does not exist!!");
        }
    }

    @Override
    public JobAdvertisements uploadJobAvertisemet(JobAdvertisements jobAdvertisements) {
        return jobAdvertisementRepository.save(jobAdvertisements);
    }

    @Override
    public void deleteJobAdvertisement(Long id) {
        jobAdvertisementRepository.deleteById(id);
    }
}
