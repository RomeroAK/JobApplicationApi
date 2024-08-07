package com.jobapplicationapi.jobapplicationapi.controller;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.service.JobadvertisementServiceImp;
import com.jobapplicationapi.jobapplicationapi.service.RecruiterServiceImp;

import com.jobapplicationapi.jobapplicationapi.entities.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterServiceImp serviceImp;

    @Autowired
    private JobadvertisementServiceImp jobServiceImp;

    @GetMapping
    public ResponseEntity<List<Recruiter>>getAllRecruiters(){
        List<Recruiter> users = serviceImp.getAllRecruiters();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{compantId}")
    public ResponseEntity<Recruiter> getRecruiterByCompanyId(@PathVariable Long companyId){
        Optional<Recruiter> recruiter = serviceImp.getRecruiterById(companyId);
        if(recruiter.isPresent()){
            return ResponseEntity.ok(recruiter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Recruiter> createNewRecruiter(@RequestBody Recruiter recruiter){
        Recruiter newRecruiter = serviceImp.saveRecruiter(recruiter);
        return ResponseEntity.ok(newRecruiter);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Recruiter> updateRecruiterDetails(@PathVariable Long companyId, @RequestBody Recruiter recruiter){
        recruiter.setCompanyId(companyId);
        Recruiter updateRecruiter = serviceImp.updateRecruiter(recruiter);
        return ResponseEntity.ok(updateRecruiter);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecruiter(@PathVariable Long companyId){
        serviceImp.deleteRecruiter(companyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/jobs")
    public ResponseEntity<JobAdvertisements> uploadNewJobvaancy(@RequestBody JobAdvertisements newJob){
        jobServiceImp.uploadJobAvertisemet(newJob);
        return ResponseEntity.ok(newJob);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<JobAdvertisements> updateJob(@PathVariable Long id, @RequestBody JobAdvertisements jobAdvertisements){
        jobAdvertisements.setJobId(id);
        JobAdvertisements updateJob = jobServiceImp.updateJobInfo(jobAdvertisements);
        return ResponseEntity.ok(updateJob);
    }
}
