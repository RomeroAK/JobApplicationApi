package com.jobapplicationapi.jobapplicationapi.controller;

import com.jobapplicationapi.jobapplicationapi.service.JobSeekerService;
import com.jobapplicationapi.jobapplicationapi.users.JobSeeker;
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

}
