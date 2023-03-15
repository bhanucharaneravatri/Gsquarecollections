/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

import java.util.List;

/**
 *
 * @author charanbhanu4
 */
public class Criteria {

    private List<String> make;
    private List<String> rentalGroup;

    private DatePeriod datePeriod;

    public Criteria(double maxCostPerDay, double minCostPerDay, DatePeriod datePeriod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public List<String> getMake() {
        return make;
    }






    public List<String> getRentalGroup() {
        return rentalGroup;
    }


    public double getMaxCostPerDay() {
        return maxCostPerDay;
    }



    public double getMinCostPerDay() {
        return minCostPerDay;
    }



    private double maxCostPerDay;
    private double minCostPerDay;

    @Override
    public String toString() {
        return "Criteria{" +
                "make=" + make +
                ", rentalGroup=" + rentalGroup +
                ", datePeriod=" + datePeriod +
                ", maxCostPerDay=" + maxCostPerDay +
                ", minCostPerDay=" + minCostPerDay +
                '}';
    }

    public Criteria(List<String> make, 
                    List<String> rentalGroup, double maxCostPerDay, double minCostPerDay,
                    DatePeriod datePeriod)
    {
        this.make = make;
        this.rentalGroup = rentalGroup;
        assert minCostPerDay <= maxCostPerDay;
        this.minCostPerDay = minCostPerDay;
        this.maxCostPerDay = maxCostPerDay;
        this.datePeriod=datePeriod;
    }

    public DatePeriod getDatePeriod() {
        return this.datePeriod;
    }
}
