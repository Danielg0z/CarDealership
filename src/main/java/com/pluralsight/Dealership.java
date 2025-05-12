package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory; //stores list

    //-------
    public Dealership(String name, String address, String phone) {
        inventory = new ArrayList<>(); // list of vehicles
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    // constructor getters/setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//This method helps you DRY(Don't Repeat Yourself) for all the filters
//Here’s how to decide if a vehicle matches per specific description
// the Predicate<Vehicle> test, uses test(a rule)
// to decide sees if a vehicle should be included
private ArrayList<Vehicle> filterVehicles(Predicate<Vehicle> test){
        ArrayList<Vehicle> matches = new ArrayList<>(); // stores matches in an empty list
    // You do the loop for vehicles in the inventory
    for(Vehicle vehicle : inventory) {
       //checks if the test passes on the current vehicle
        if(test.test(vehicle)){
            // if the vehicle passes the test, the vehicle gets added to the matches list
            matches.add(vehicle);
        }
    }
    return matches;
}

    // iterations of the matches list per specific variables

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max){
    return filterVehicles(vehicle ->
            vehicle.getPrice() >= min && vehicle.getPrice() <= max);
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        return filterVehicles(vehicle ->
                vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model));
    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max){
        return filterVehicles(vehicle ->
                vehicle.getYear() >= min && vehicle.getYear() <= max);
    }

    public ArrayList<Vehicle> getVehicleByColor(String color){
        return filterVehicles(vehicle ->
                vehicle.getColor().equalsIgnoreCase(color));
    }

    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
    return filterVehicles(vehicle ->
            vehicle.getOdometer() >= min && vehicle.getOdometer() <= max);
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        return filterVehicles(vehicle ->
                vehicle.getVehicleType().equalsIgnoreCase(vehicleType));
    }


    public ArrayList<Vehicle> getAllVehicles(){
    return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
}
