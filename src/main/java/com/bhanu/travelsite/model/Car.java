/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

/**
 *
 * @author charanbhanu4
 */
public class Car {
    private final int carId;
    private final String make;
    private final String model;
    private final String rentalGroup;
    private final String registrationNumber;
    private final double costPerDay;
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getRentalGroup() {
        return rentalGroup;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public double getCostPerDay() {
        return costPerDay;
    }
    public Car(int carId,String make, String model, String registrationNumber, String rentalGroup, double costPerDay) {
        this.carId=carId;
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.rentalGroup = rentalGroup;
        this.costPerDay = costPerDay;
    }
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", rentalGroup='" + rentalGroup + '\'' +
                '}';
    }
    public int getCarId() {
    return this.carId;
    }
}
