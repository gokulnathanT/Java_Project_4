package org.example.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trip {

    private String tripName;
    private String[] tripPLaces;
    private LocalDate startDate;
    private LocalDate endDate;
    private String purpose;
    private ArrayList<String> activities;

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

    @Override
    public String toString() {
        return "Trip{" +
                ", tripName='" + tripName + '\'' +
                "activities=" + activities +
                ", purpose='" + purpose + '\'' +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", tripPLaces=" + Arrays.toString(tripPLaces) +
                '}';
    }
}
