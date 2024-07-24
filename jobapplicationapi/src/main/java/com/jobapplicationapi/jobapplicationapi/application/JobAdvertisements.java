package com.jobapplicationapi.jobapplicationapi.application;


import jakarta.persistence.Entity;
import com.jobapplicationapi.jobapplicationapi.entities.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class JobAdvertisements {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long jobId;
    private String vacancyTitle;
    private double salary;
    private LocalDate startDate;
    private LocalDate applicationCloseDate;
    private Recruiter recruiter;
    private int numberOfApplicants;



    public JobAdvertisements() {
    }

    public JobAdvertisements(LocalDate applicationCloseDate, Recruiter recruiter, LocalDate startDate, double salary, String vacancyTitle, Long jobId) {
        this.applicationCloseDate = applicationCloseDate;
        this.recruiter = recruiter;
        this.startDate = startDate;
        this.salary = salary;
        this.vacancyTitle = vacancyTitle;
        this.jobId = jobId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public LocalDate getApplicationCloseDate() {
        return applicationCloseDate;
    }

    public void setApplicationCloseDate(LocalDate applicationCloseDate) {
        this.applicationCloseDate = applicationCloseDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getVacancyTitle() {
        return vacancyTitle;
    }

    public void setVacancyTitle(String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    public int getNumberOfApplicants() {
        return numberOfApplicants;
    }

    public void setNumberOfApplicants(int numberOfApplicants) {
        this.numberOfApplicants = numberOfApplicants;
    }

    @Override
    public String
    toString() {
        return "JobAdvertisements{" +
                "jobId=" + jobId +
                ", vacancyTitle='" + vacancyTitle + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", applicationCloseDate=" + applicationCloseDate +
                ", recruiter=" + recruiter +
                ", numberOfApplicants=" + numberOfApplicants +
                '}';
    }
}
