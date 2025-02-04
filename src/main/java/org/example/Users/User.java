package org.example.Users;

import org.example.Trip.Trip;

import java.util.ArrayList;

public class User {
    private String userName;
    private ArrayList<Trip> userTrip =new ArrayList<>();
    private long mobileNo;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public User(String userName, long mobileNo) {
        this.userName = userName;
        this.mobileNo = mobileNo;
    }

    public ArrayList<Trip> getUserTrip() {
        return userTrip;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userTrip=" + userTrip +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
