package com.pluralsight;

public class SalesContract extends Contract{

    // constructor
    public SalesContract(String contractDate, String customerName, String email, Vehicle vehicleSold){
        super(contractDate,customerName,email,vehicleSold);
    }


    @Override
    public double getTotalPrice(){
        return 0;
    }

    @Override
    public double getMonthlyPayment(){
        return 0;
    }

}
