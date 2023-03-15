/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author charanbhanu4
 */
public class CarRentalCompany {
    private List<Car> cars;
    private HashSet<Renter> renters=new HashSet<>();
    private List<String> makes;
    private List<String> groups;    
    private HashMap<String,List<Car>>makeCars=new HashMap<>();
    private HashMap<String,List<Car>>rentalGroupCars=new HashMap<>();

    public CarRentalCompany() {
        this.cars = new ArrayList<>();
    }
    
    public HashMap<String,List<Car>> getMakeCars()
    {
        return this.makeCars;
    }
    
    public void setMakeCars()
    {
        HashMap<String,List<Car>> MM=new HashMap<>();
        this.makes.forEach((var make) -> {
            List<Car> makeListCars=this.cars.stream().filter(car->car.getMake().equals(make)).collect(Collectors.toList());
            MM.put(make,makeListCars);
        });
        this.makeCars=MM;
    }
    public void setRentalGroupCars()
    {
        HashMap<String,List<Car>> RGM=new HashMap<>();
        groups.forEach((var rentalGroup) -> {
            List<Car> makeListCars=this.cars.stream()
                    .filter(car->car.getRentalGroup().equals(rentalGroup))
                    .collect(Collectors.toList());
            RGM.put(rentalGroup,makeListCars);
        });
        this.rentalGroupCars=RGM;
    }
    public HashMap<String,List<Car>> getRentalGroupCars()
    {
        return this.rentalGroupCars;
    }
    public void addCar(Car car) {
        cars.add(car);
    }


    public void rentCar(Renter renter, Car car) 
    {
        renter.setBookedCar(car);
        this.renters.add(renter);
    }

    public void returnCar(Renter renter, Car car) 
    {
        this.renters.remove(renter);
    }

    public List<Car> matchingCars(Criteria criteria)  {
        List<Car> ans=new ArrayList<>();
        List<String> makeWishList=criteria.getMake();
        for(String str:makeWishList)
        {
            ans.addAll(this.makeCars.get(str));
        }
               return ans
                .stream()
                .filter(car->criteria.getRentalGroup().contains(car.getRentalGroup()))
                .filter(car->car.getCostPerDay()>=criteria.getMinCostPerDay() && car.getCostPerDay()<=criteria.getMaxCostPerDay())
                .filter(car->isAvailable(car,criteria)).collect(Collectors.toList());
     }

    private boolean isAvailable(Car car, Criteria criteria) {
        for(Renter r:this.renters)
        {
            if(isCarBookedByRenterOnCriteriaDatePeriod(r,car,criteria))
                return false;
        }
         return true;   
    }
    private boolean isCarBookedByRenterOnCriteriaDatePeriod(Renter r, Car car, Criteria criteria) {
        if(r.getBookedCar().getRegistrationNumber().equals(car.getRegistrationNumber()))
        {
            if (DatePeriodUtil.areOverlapping(r.getDatePeriod(),criteria.getDatePeriod()))
                return true;
        }
        return false;    
    }

    public void setRenters(HashSet<Renter> renters) {
    this.renters=renters;    
    }

    public void setCars(List<Car> cars) {
        this.cars=cars; }
    public void setMakes(List<String> makes) {
        this.makes=makes; }
    public void setGroups(List<String> groups) {
        this.groups=groups; }

    public List<Car> getCars() {
    return this.cars;    
    }
    
}
