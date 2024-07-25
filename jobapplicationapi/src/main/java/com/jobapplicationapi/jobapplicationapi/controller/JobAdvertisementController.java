package com.jobapplicationapi.jobapplicationapi.controller;

import com.jobapplicationapi.jobapplicationapi.application.JobAdvertisements;
import com.jobapplicationapi.jobapplicationapi.service.JobadvertisementServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/openvacancies"))
public class JobAdvertisementController {

    @Autowired
    private JobadvertisementServiceImp jobadvertisementServiceImp;

    @GetMapping
    public ResponseEntity<List<JobAdvertisements>> getAllJobAdverts(){
        List<JobAdvertisements> jobs = jobadvertisementServiceImp.getAllJobAdvertisements();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAdvertisements> getJobAdvertById(@PathVariable Long id){
        Optional<JobAdvertisements> jobAdvert = jobadvertisementServiceImp.getAJobAdvertisementById(id);
        if(jobAdvert.isPresent()){
            return ResponseEntity.ok(jobAdvert.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/vacanciessByRecruiter/{recruiterId}")
    public ResponseEntity<List<JobAdvertisements>> getJoBAdvertsByRecruiter(@PathVariable Long recruiterId){
        List<JobAdvertisements> jobAdsyRecruiter = jobadvertisementServiceImp.getJobAdvertByRecruiterId(recruiterId);
        if(jobAdsyRecruiter.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobAdsyRecruiter);
        }
    }

    @PostMapping
    public ResponseEntity<JobAdvertisements> createNewJobAdvert(@RequestBody JobAdvertisements jobad){
        JobAdvertisements newJobAd = jobadvertisementServiceImp.uploadJobAvertisemet(jobad);
        return ResponseEntity.ok(newJobAd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobAdvertisements> updateJobAdvertInfo(@PathVariable Long id, @RequestBody JobAdvertisements jobAdvert){
        jobAdvert.setJobId(id);
        JobAdvertisements updateJobAdvert = jobadvertisementServiceImp.updateJobInfo(jobAdvert);
        return ResponseEntity.ok(updateJobAdvert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobAdvert(@PathVariable Long id){
        jobadvertisementServiceImp.deleteJobAdvertisement(id);
        return ResponseEntity.noContent().build();
    }

}
