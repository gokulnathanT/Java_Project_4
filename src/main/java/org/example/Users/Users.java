package org.example.Users;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> userList;

    public Users() {
        userList=new ArrayList<>();
    }
    public void addUser(User user){
        userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
