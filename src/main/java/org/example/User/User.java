package org.example.User;

public class User {
    private int userID;

    int id=1;
    private String userName;

    private long mobileNo;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

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
        this.userID = id;
        this.userName = userName;
        this.mobileNo = mobileNo;
        id++;
    }
}
