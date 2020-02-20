/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;


/**
 *
 * @author Gunjan
 */
public class Customer {
    
    String customerName;
    long customerContact;
    String customerEmail;
    private String seatNumber;
    private String flightNumber;
    private ArrayList<AirlinerDirectory> airlinerDirectory;

     public Customer(String customerName,long customerContact, String customerEmail,String flightNumber, String seatNumber){
       // airlinerDirectory = new ArrayList<>(); 
        this.customerName =customerName ;
        this.customerEmail = customerEmail;
        this.customerContact = customerContact;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        
    }
    public ArrayList<AirlinerDirectory> getAirlinerdirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerdirectory(ArrayList<AirlinerDirectory> airlinerdirectory) {
        this.airlinerDirectory = airlinerdirectory;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(long customerContact) {
        this.customerContact = customerContact;
    }

    

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

   
    @Override
    public String toString() {
        return customerName;
    }
}
