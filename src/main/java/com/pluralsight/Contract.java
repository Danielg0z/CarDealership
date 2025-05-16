package com.pluralsight;

public abstract class Contract {
protected String contract;
protected String name;
protected String email;
protected boolean vehicleSold;
protected double totalPrice;
protected double monthlyPayment;

    public Contract(String contract, String name, String email, boolean vehicleSold, double totalPrice, double monthlyPayment) {
        this.contract = contract;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getContract() {
        return this.contract;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isVehicleSold() {
        return this.vehicleSold;
    }

    public abstract double getTotalPrice(); // specific towards contract type

    public  abstract double getMonthlyPayment(); // specific towards contract type

    public void setContract(String contract) {
        this.contract = contract;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }



}
