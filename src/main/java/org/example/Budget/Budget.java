package org.example.Budget;

import java.util.HashMap;

public class Budget {
     private int accommodationBudget;
     private int transportBudget;
     private int food;
     private int miscellaneous;
     private int total;
    public Budget(int accommodationBudget, int transportBudget, int food, int miscellaneous) {
        this.accommodationBudget = accommodationBudget;
        this.transportBudget = transportBudget;
        this.food = food;
        this.miscellaneous = miscellaneous;
        this.total=accommodationBudget+transportBudget+food+miscellaneous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAccommodationBudget() {
        return accommodationBudget;
    }

    public void setAccommodationBudget(int accommodationBudget) {
        this.accommodationBudget = accommodationBudget;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getTransportBudget() {
        return transportBudget;
    }

    public void setTransportBudget(int transportBudget) {
        this.transportBudget = transportBudget;
    }

    public int getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(int miscellaneous) {
        this.miscellaneous = miscellaneous;
    }


    public String toString() {
        return "Budget{" +
                "\n Accommodation=" + accommodationBudget +
                ",\n Transport=" + transportBudget +
                ",\n Food=" + food +
                ",\n Miscellaneous=" + miscellaneous +
                ",\n Total=" + total +
                '}';
    }
}
