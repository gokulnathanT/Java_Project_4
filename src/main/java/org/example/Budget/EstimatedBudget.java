package org.example.Budget;

import org.example.Trip.Trip;

public class EstimatedBudget {
    private int room=1400;
    private int convenienceFee=300;
    private int foodPerMeal=500;
    private int miscellaneous=1000;
    private int fuel=100;
    private int transport=3000;
    private int entry=1000;
    private int estimatedCost;

    public EstimatedBudget() {
        this.estimatedCost=0;
    }
    public int estimateCost(Budget providedBudget, Trip trip){
        estimatedCost+=trip.getDays()*room*trip.getTripPLaces().length;
        estimatedCost+=trip.getDays()*miscellaneous;
        estimatedCost+=trip.getDays()*foodPerMeal*4;
        estimatedCost+=entry;
        estimatedCost+=transport*trip.getTripPLaces().length;
        estimatedCost+=convenienceFee;
        return estimatedCost;
    }
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getConvenienceFee() {
        return convenienceFee;
    }

    public void setConvenienceFee(int convenienceFee) {
        this.convenienceFee = convenienceFee;
    }

    public int getFoodPerMeal() {
        return foodPerMeal;
    }

    public void setFoodPerMeal(int foodPerMeal) {
        this.foodPerMeal = foodPerMeal;
    }

    public int getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(int miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
