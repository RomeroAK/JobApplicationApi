package com.jobapplicationapi.jobapplicationapi.service;


import com.jobapplicationapi.jobapplicationapi.entities.Recruiter;

import java.util.List;
import java.util.Optional;


public interface RecruiterService {

    Recruiter saveRecruiter(Recruiter recruiter);
    Recruiter updateRecruiter(Recruiter recruiter);
    void deleteRecruiter(Long Id);
    Optional<Recruiter> getRecruiterById(Long Id);
    List<Recruiter> getAllRecruiters();
}
