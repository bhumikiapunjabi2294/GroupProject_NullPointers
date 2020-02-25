/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Yash
 */
public class Planes {
    int totalSeats;
    String planeName;
    private int airlinerFleetSize;
    public ArrayList<Flight> flightList;
    private String airlinerName;
    public Planes(String airlinerName,String planeName, int totalSeats){
        flightList=new ArrayList<>();
        this.airlinerName = airlinerName;
        this.planeName = planeName;
        this.totalSeats = totalSeats;
    }

    public int getAirlinerFleetSize() {
        return airlinerFleetSize;
    }

    public void setAirlinerFleetSize(int airlinerFleetSize) {
        this.airlinerFleetSize = airlinerFleetSize;
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }
     @Override
    public String toString(){
        return this.planeName;
    }
    
}
