package org.example.Trip;

import org.example.Budget.Budget;
import org.example.Budget.EstimatedBudget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Trip {

    private String tripName;
    private String[] tripPLaces;
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;
    private ArrayList<String> activities;
    private Budget tripBudget;
    private int days;

    private String summary;
    public Trip(String tripName, String[] tripPLaces, LocalDate startDate, LocalDate endDate, int purpose, ArrayList<Integer> activities) {
        this.tripName = tripName;
        this.tripPLaces = tripPLaces;
        this.startDate = startDate;
        this.endDate = endDate;
        this.purpose = defaultPurpose.get(purpose);

        ArrayList<String> act=new ArrayList<>();
        for(int i:activities){
            act.add(defaultActivities.get(i));
        }
       this.activities=act;
       this.days=(int)ChronoUnit.DAYS.between(startDate,endDate);
    }
    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String[] getTripPLaces() {
        return tripPLaces;
    }

    public void setTripPLaces(String[] tripPLaces) {
        this.tripPLaces = tripPLaces;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }

    public Budget getTripBudget() {
        return tripBudget;
    }

    public void setTripBudget(Budget tripBudget) {
        this.tripBudget = tripBudget;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public HashMap<Integer, String> defaultActivities = new HashMap() {{
        put(1, "Hiking");
        put(2, "Snorkeling");
        put(3, "Cycling-Tour");
        put(4, "Zip-lining");
        put(5, "HotAir-Balloon Ride");
        put(6, "FoodTasting-Tour");
        put(7, "Historical-Sightseeing");
        put(8, "Beach-Camping");
        put(9, "Wildlife-Safari");
        put(10, "Photography-Walk");
    }};

    public HashMap<Integer,String> defaultPurpose=new HashMap(){{
        put(1,"leisure");
        put(2,"business");
        put(3,"family-visit");
    }};


    public String toString() {
        return "Trip{" +
                ", tripName='" + tripName + '\'' +
                "activities=" + activities +
                ", purpose='" + purpose + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", Days=" + days +
                ", tripPLaces=" + Arrays.toString(tripPLaces) +
                '}';
    }

    public String generateSummary(Trip trip, Budget budget, EstimatedBudget estimatedBudget) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String tripDetails = "📌 Trip Summary: " + trip.getTripName() + "\n" +
                "------------------------------------------------\n" +
                "📅 Duration: " + trip.getStartDate().format(formatter) + " to " +
                trip.getEndDate().format(formatter) + " (" + trip.getDays() + " days)\n" +
                "🌍 Places to Visit: " + String.join(", ", trip.getTripPLaces()) + "\n" +
                "🎯 Purpose: " + trip.getPurpose() + "\n" +
                "📝 Activities Planned: " + String.join(", ", trip.getActivities()) + "\n\n";
        String budgetBreakdown = "💰 Budget Breakdown:\n" +
                "🏨 Accommodation: $" + budget.getAccommodationBudget() + "\n" +
                "🚗 Transport: $" + budget.getTransportBudget() + "\n" +
                "🍽️ Food: $" + budget.getFood() + "\n" +
                "🎭 Miscellaneous: $" + budget.getMiscellaneous() + "\n" +
                "💵 Total Budget: $" + budget.getTotal() + "\n\n";
        String estimatedBreakdown = "📊 Estimated Cost Analysis:\n" +
                "🏨 Accommodation: $" + ((estimatedBudget.getRoom()*trip.getDays()*trip.getTripPLaces().length)+ estimatedBudget.getConvenienceFee()) + "\n" +
                "🚗 Transport: $" + estimatedBudget.getTransport()* trip.getTripPLaces().length + "\n" +
                "🍽️ Food: $" + estimatedBudget.getFoodPerMeal()*trip.getDays()*4 + "\n" +
                "🎭 Miscellaneous: $" + estimatedBudget.getMiscellaneous()*trip.getDays()+ "\n" +
                "💵 Estimated Total: $" + estimatedBudget.estimateCost(budget,trip) + "\n\n";




        return tripDetails + budgetBreakdown + estimatedBreakdown + "✅ Budget Status: \n------------------------------------------------";
    }
}
