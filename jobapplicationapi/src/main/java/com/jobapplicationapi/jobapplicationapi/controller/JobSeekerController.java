package com.jobapplicationapi.jobapplicationapi.controller;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.service.JobSeekerService;
import com.jobapplicationapi.jobapplicationapi.entities.JobSeeker;
import com.jobapplicationapi.jobapplicationapi.service.JobadvertisementServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    @Autowired
    private  JobSeekerService jobSeekerService;

    @Autowired
    private JobadvertisementServiceImp serviceImp;

    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers(){
        List<JobSeeker> users = jobSeekerService.getAllJobSeekers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long Id){
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(Id);
        if(jobSeeker.isPresent()){
            return ResponseEntity.ok(jobSeeker.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker){
        JobSeeker savedJobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
        return ResponseEntity.ok(savedJobSeeker);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<JobSeeker> updateUser(@PathVariable Long Id, @RequestBody JobSeeker jobSeeker){
        jobSeeker.setId(Id);
        JobSeeker updateJobSeeker = jobSeekerService.updateJobSeeker(jobSeeker);
        return ResponseEntity.ok(updateJobSeeker);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long Id){
        jobSeekerService.deleteJobSeeker(Id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/apply/{jobId}")
    public ResponseEntity<Boolean> applyToJobVacancy(@PathVariable Long id, @PathVariable Long jobId){
        Optional<JobAdvertisements> jbOptional = serviceImp.getAJobAdvertisementById(jobId);
        if (jbOptional.isPresent()){
            jobSeekerService.applyToJob(id,jbOptional.get());
            return ResponseEntity.ok(true);
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/cancel/{jobId}")
    public ResponseEntity<Boolean> cancelApplication(@PathVariable Long id, @PathVariable Long jobId){
        Optional<JobAdvertisements> jbOptional = serviceImp.getAJobAdvertisementById(jobId);
        if(jbOptional.isPresent()){
            jobSeekerService.cancelApplication(id,jbOptional.get());
            return ResponseEntity.ok(true);
        } else return ResponseEntity.notFound().build();
    }

}
