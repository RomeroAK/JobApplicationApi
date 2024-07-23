package com.jobapplicationapi.jobapplicationapi.controller;

import com.jobapplicationapi.jobapplicationapi.users.JobSeeker;
import com.jobapplicationapi.jobapplicationapi.users.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterController recruiterController;

    @GetMapping
    public ResponseEntity<List<Recruiter> getAllRecruiters(){
        List<Recruiter> users = jobSeekerService.getAllJobSeekers();
        return ResponseEntity.ok(users);
    }
}
