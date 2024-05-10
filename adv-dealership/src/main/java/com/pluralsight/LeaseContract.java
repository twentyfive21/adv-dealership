package com.pluralsight;

// LeaseContract class inherits from Contract class
public class LeaseContract extends Contract{

    // members
   private double leaseFee; // Fee for leasing the vehicle
   private double expectedValue; // Expected value of the leased vehicle at the end of the contract

    // constructor
    public LeaseContract(String contractDate, String customerName, String email, Vehicle vehicleSold){
        // Call to superclass constructor
        super(contractDate,customerName,email,vehicleSold);
        this.leaseFee = vehicleSold.getPrice() * 0.07; // Lease fee is 7% of vehicle price
        this.expectedValue = vehicleSold.getPrice() * 0.5;  // Expected value is 50% of vehicle price
    }

    @Override
    public double getTotalPrice(){
        double totalPrice = getTotalPrice() + leaseFee + expectedValue;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment(){
        // P = (T × r) / (1 - (1 + r)^-n)
        // t = total price , r intrest rate, n is loan term 36months
        double total = getTotalPrice();
        double interest = 0.4;
        int loanTerm = 36;
        double monthly = (total * interest) / (1 - Math.pow(1 + interest, -loanTerm));
        return monthly;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "leaseFee=" + leaseFee +
                ", expectedValue=" + expectedValue +
                '}';
    }
}
