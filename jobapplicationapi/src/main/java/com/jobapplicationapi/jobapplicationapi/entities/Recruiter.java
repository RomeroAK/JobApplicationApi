package com.jobapplicationapi.jobapplicationapi.entities;

import jakarta.persistence.*;
import com.jobapplicationapi.jobapplicationapi.address.Address;

@Entity
public class Recruiter{

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long CompanyId;
   private String CompanyName;
   private String emailAddress;
   private String website;
   private boolean active;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private Address address;

   public Recruiter(){}
    public Recruiter(Long companyId, boolean active, String website, String emailAddress, String companyName, Address address) {
        CompanyId = companyId;
        this.active = active;
        this.website = website;
        this.emailAddress = emailAddress;
        CompanyName = companyName;
        this.address = address;
    }

    public Long getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(Long companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "CompanyId=" + CompanyId +
                ", CompanyName='" + CompanyName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", website='" + website + '\'' +
                ", active=" + active +
                ", address=" + address +
                '}';
    }
}
