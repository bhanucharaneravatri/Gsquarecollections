package com.bhanu.travelsite.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    CarRentalCompany carRentalCompany = new CarRentalCompany();
    carRentalCompany.addCar(new Car("Benz","2019","1234",
            "luxury",8999.99));
    carRentalCompany.addCar(new Car("Audi","2020","1235",
            "luxury",9999.99));
    carRentalCompany.addCar(new Car("Honda","2021","1236",
            "Sedan",5999.99));
    carRentalCompany.addCar(new Car("Tesla","2022","1237",
            "luxury",10999.99));
    carRentalCompany.addCar(new Car("Swift","2018","1238",
            "hatchback",2999.99));
    carRentalCompany.addCar(new Car("Nano","2020","1239",
            "mini",999.99));

    System.out.println("Added Cars");
    System.out.println("carRentalComp "+carRentalCompany);
    DatePeriod newrenterDatePeriod=new DatePeriod( LocalDate.of(2023,4,1),
            LocalDate.of(2023,6,2));
    Renter newRenter=new Renter("Bhanu", "Eravatri","X12A34",LocalDate.of(1993,01,02));
    newRenter.setDatePeriod(newrenterDatePeriod);
    Car newRenterBookedCar=new Car("Benz","2019","1234",
            "luxury",8999.99);


    System.out.println(newRenter+"Booked a car. it's details are "+newRenterBookedCar);
    carRentalCompany.rentCar(newRenter,newRenterBookedCar);

    System.out.println("carRentComp"+carRentalCompany);
    DatePeriod searchingDatePeriod=new DatePeriod( LocalDate.of(2023,4,1),
                LocalDate.of(2023,6,2) );
    Criteria c = new Criteria(Arrays.asList("Benz"),
            Arrays.asList("luxury"),10000,100,searchingDatePeriod);
    System.out.println("Searching Cars are as per criteria "+c);
    System.out.println(
            carRentalCompany.matchingCars(c ));
    System.out.println("car Returned");
    carRentalCompany.returnCar(newRenter,newRenterBookedCar);
        System.out.println("Searching Cars are as per criteria "+c);
        System.out.println(
                carRentalCompany.matchingCars(c ));
    }
}
