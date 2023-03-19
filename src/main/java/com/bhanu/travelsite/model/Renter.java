/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

import java.time.LocalDate;

/**
 *
 * @author charanbhanu4
 */
public class Renter {
    private final LocalDate DateofBirth;
    private final String LastName;
    private final String FirstName;
    private final String drivingLicense;
    private DatePeriod datePeriod;
    private Car bookedCar;

    public void setDatePeriod(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
    }
    public Renter(String FirstName, String LastName, String drivingLicense, LocalDate DateofBirth,DatePeriod dp, Car car) {
        this.FirstName = FirstName;
        this.LastName= LastName;
        this.drivingLicense = drivingLicense;
        this.DateofBirth=DateofBirth;
        this.datePeriod=dp;
        this.bookedCar=car;
    }

    public Renter(String firstName, String LastName, String drivingLicense, LocalDate DateofBirth) {
        this.FirstName = firstName;
        this.LastName= LastName;
        this.drivingLicense = drivingLicense;
        this.DateofBirth=DateofBirth;
    }
    public DatePeriod getDatePeriod()
    {
        return this.datePeriod;
    }
    public Car getBookedCar() {
        return bookedCar;
    }


    public void setBookedCar(Car car) {
        this.bookedCar=car;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "DateofBirth=" + DateofBirth +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", datePeriod=" + datePeriod +
                ", bookedCar=" + bookedCar +
                '}';
    }
}
