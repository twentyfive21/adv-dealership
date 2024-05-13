package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {

    public void saveContract(Contract contract){
        try{ // set pipe variable for writing
            final String pipe = "|";

            // get vehicle data to have buf write readable when formatting
            int vin = contract.getVehicleSold().getVin();
            String customerName = contract.getCustomerName();
            String customerEmail = contract.getEmail();
            int odometer = contract.getVehicleSold().getOdometer();
            int year = contract.getVehicleSold().getYear();
            String make = contract.getVehicleSold().getMake();
            String model = contract.getVehicleSold().getModel();
            String type = contract.getVehicleSold().getVehicleType();
            String color = contract.getVehicleSold().getColor();
            double total = contract.getTotalPrice();
            double payment = contract.getMonthlyPayment();


            // create writer and file writer
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("contract.csv"));

            // if lease instance
            if(contract instanceof LeaseContract){
            bufWriter.write("LEASE" + pipe + vin + pipe + customerName + pipe +
                    customerEmail + pipe + odometer + pipe + year + pipe + make + pipe + model
                    + pipe + type + pipe + color + pipe + total + pipe + payment);
            }

            // if sales instance
            if (contract instanceof SalesContract){
                // check if they chose to finance or not
                String financeOption = ((SalesContract) contract).isFinance() ? "YES" : "NO";
                // write to file the sale
                bufWriter.write("SALE" + pipe + vin + pipe + customerName + pipe +
                        customerEmail + pipe + odometer + pipe + year + pipe + make + pipe + model
                        + pipe + type + pipe + color + pipe + total + pipe +
                        financeOption + pipe + payment);

            }
            // new line for next contract that is written
            bufWriter.newLine();
            // close writer
            // bufWriter.flush();
            bufWriter.close();
        } catch(Exception e){
            System.out.println("Error writing to contract file");
        }

    }

}
