package com.jobapplicationapi.jobapplicationapi.application;


import com.jobapplicationapi.jobapplicationapi.entities.Recruiter;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "openvacancies")
public class JobAdvertisements {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long jobId;
    private String vacancyTitle;
    private double salary;
    private LocalDate startDate;
    private LocalDate applicationCloseDate;
    private Long recruiterId;
    private int numberOfApplicants;



    public JobAdvertisements() {
    }

    public JobAdvertisements(LocalDate applicationCloseDate, Long recruiterId, LocalDate startDate, double salary, String vacancyTitle, Long jobId) {
        this.applicationCloseDate = applicationCloseDate;
        this.recruiterId = recruiterId;
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

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Recruiter recruiterId) {
        this.recruiterId = recruiterId.getCompanyId();
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
                ", recruiterId=" + recruiterId +
                ", numberOfApplicants=" + numberOfApplicants +
                '}';
    }
}
