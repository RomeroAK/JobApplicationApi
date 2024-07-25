package com.jobapplicationapi.jobapplicationapi.service;

import com.jobapplicationapi.jobapplicationapi.repository.RicruiterRepository;
import com.jobapplicationapi.jobapplicationapi.entities.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterServiceImp implements RecruiterService{

    @Autowired
    private RicruiterRepository repository;

    @Override
    public Recruiter saveRecruiter(Recruiter recruiter) {
        return repository.save(recruiter);
    }

    @Override
    public Recruiter updateRecruiter(Recruiter recruiter) {
        Optional<Recruiter> recruiter1 = repository.findById(recruiter.getCompanyId());
        if(recruiter1.isPresent()){
            Recruiter existingRecruiter = recruiter1.get();
            existingRecruiter.setCompanyName(recruiter.getCompanyName());
            existingRecruiter.setEmailAddress(recruiter.getEmailAddress());
            return repository.save(existingRecruiter);
        } else {
            throw new RuntimeException("Recruiter with Id "+ recruiter.getCompanyId() + "is not found!");
        }
    }

    @Override
    public void deleteRecruiter(Long Id) {
        repository.deleteById(Id);

    }

    @Override
    public Optional<Recruiter> getRecruiterById(Long Id) {
        return repository.findById(Id);
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        return repository.findAll();
    }
}
