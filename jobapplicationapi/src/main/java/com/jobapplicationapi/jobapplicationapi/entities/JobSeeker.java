package com.jobapplicationapi.jobapplicationapi.users;

import jakarta.persistence.*;
import com.jobapplicationapi.jobapplicationapi.address.Address;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name = "jobseeker")
public class JobSeeker{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;

    private Address address;

    @Column(name = "id_num",length = 16,nullable = false,unique = true)
    private String idNumber;
    private boolean currentlyEmployed;

    public JobSeeker() {

    }

    public JobSeeker(boolean currentlyEmployed, String idNumber, String gender, Address address, int age, String surname, String name) {
        this.currentlyEmployed = currentlyEmployed;
        this.idNumber = idNumber;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int year, int day, int month) {
        LocalDate birthDate = LocalDate.of(year,month,day);
        LocalDate currentDate = LocalDate.now();
        this.age = Period.between(birthDate,currentDate).getYears();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", idNumber='" + idNumber + '\'' +
                ", currentlyEmployed=" + currentlyEmployed +
                '}';
    }
}
