package org.example;

import org.example.Budget.Budget;
import org.example.Trip.Trip;
import org.example.Users.User;
import org.example.Users.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Track & Go !");
        System.out.println("TRAVEL PLANNER AND EXPENSE ESTIMATOR");
        Scanner sc=new Scanner(System.in);
        Users userList=new Users();


        while(true) {
            System.out.println("Enter desired operation ! ");
            System.out.println("1 : Creating user \n2 : Provide Trip details \n3 : Butget for added trip \n4 : Get estimated budget \n5 : exit");
            int operation = sc.nextInt();
            switch (operation) {

                case 1:
                    System.out.println("Creating user... ");
                    System.out.print("Name : ");
                    String name = sc.next();
                    System.out.print("Mobile no : ");
                    long mobileNo = sc.nextLong();
                    User user = new User(name, mobileNo);
                    userList.addUser(user);
                    System.out.println("User created !");
                    System.out.println("Name : " + user.getUserName());
                    System.out.println("Mobile : " + user.getMobileNo());
                    System.out.println("-------------------------------------");
                    System.out.println("USER ID : "+userList.getUserList().size());
                    continue;

                case 2:
                    System.out.println("Enter user Id : ");
                    int userID=sc.nextInt();
                    if(userList.getUserList().size()<userID){
                        System.out.println("User id doesn't exist ");
                        continue;
                    }
                    else{
                        User currentUser=userList.getUserList().get(userID-1);
                        System.out.println("Trip details insert : ");
                        System.out.println("Enter trip name :");
                        sc.nextLine();
                        String Trip = sc.nextLine();
                        System.out.println("No of Places : ");
                        int n = sc.nextInt();
                        String[] places = new String[n];
                        System.out.println("Enter places :");
                        for (int i = 0; i < n; i++) {
                            System.out.print("Place " + (i + 1) + " : ");
                            places[i] = sc.next();
                        }
                        System.out.println("Enter start date (YYYY-MM-DD):");
                        String sdate = sc.next();
                        LocalDate startDate = LocalDate.parse(sdate, DateTimeFormatter.ISO_LOCAL_DATE);
                        System.out.println("Enter end date (YYYY-MM-DD):");
                        String edate = sc.next();
                        LocalDate endDate = LocalDate.parse(edate, DateTimeFormatter.ISO_LOCAL_DATE);
                        System.out.println("Select purpose ...");
                        System.out.println("1 : leisure \n2 : business \n3 : family-visit");
                        int purpose = sc.nextInt();
                        printActivities();
                        System.out.println("Enter no of activities : ");
                        int m = sc.nextInt();
                        ArrayList<Integer> activity = new ArrayList<>();
                        for (int i = 0; i < m; i++) {
                            activity.add(sc.nextInt());
                        }
                        Trip trip = new Trip(Trip, places, startDate, endDate, purpose, activity);
                        currentUser.getUserTrip().add(trip);
                        System.out.println("Trip details added ! ");
                        System.out.println("Trip ID : "+currentUser.getUserTrip().size());
                        System.out.println(trip.toString());
                    }
                    continue;
                case 3:
                    System.out.println("Enter user id");
                    int userOfTrip=sc.nextInt();
                    if(userList.getUserList().size()<userOfTrip){
                        System.out.println("No user found");
                        continue;
                    }
                    else{
                        System.out.println("Enter trip id ");
                        int tripId=sc.nextInt();
                        User tripUser=userList.getUserList().get(userOfTrip-1);
                        if(tripUser.getUserTrip().size()<tripId){
                            System.out.println("No trip found");
                            continue;
                        }
                        else{
                            Trip tripOfUser=tripUser.getUserTrip().get(tripId-1);
                            System.out.println("Provide budget for following ! \nAccommodation   ||   Food   ||   Transportation   ||   Miscellaneous");
                            System.out.println("Accomodation (₹): ");
                            int accomodation=sc.nextInt();
                            System.out.println("Transport (₹): ");
                            int transport=sc.nextInt();
                            System.out.println("Food (₹): ");
                            int food=sc.nextInt();
                            System.out.println("Miscellaneous (₹): ");
                            int miscellaneous=sc.nextInt();
                            System.out.println("Budget added successfully !");
                            Budget budget=new Budget(accomodation,transport,food,miscellaneous);
                            tripOfUser.setTripBudget(budget);
                            System.out.println(budget.toString());
                            continue;
                        }
                    }
                case 4:
                    System.out.println("Estimated budget ! ");
                    System.out.println("Enter user ID : ");
                    int userIDforEstimate=sc.nextInt();
                    if(userList.getUserList().size()<userIDforEstimate){
                        System.out.println("No such id exist ! Sorry");
                        continue;
                    }
                    else {
                        System.out.println("Enter your respective trip ID : ");
                        int tripIdforEstimate=sc.nextInt();
                        User tripUser=userList.getUserList().get(userIDforEstimate-1);
                        if (tripUser.getUserTrip().size()<tripIdforEstimate){
                            System.out.println("No such trip exist ! ");
                            continue;
                        }
                        else {
                            Trip tripforEstimate=tripUser.getUserTrip().get(tripIdforEstimate-1);
                            System.out.println("Getting estimates : "+tripforEstimate.getTripName());
                            System.out.println(tripforEstimate.toString());
                        }
                    }
            }
        }

    }
    private static void printActivities(){
        System.out.println("===== Available Activities =====");
        System.out.printf("%-5s | %-25s%n", "ID", "Activity");
        System.out.println("--------------------------------");
        System.out.printf("%-5d | %-25s%n", 1, "Hiking");
        System.out.printf("%-5d | %-25s%n", 2, "Snorkeling");
        System.out.printf("%-5d | %-25s%n", 3, "Cycling-Tour");
        System.out.printf("%-5d | %-25s%n", 4, "Zip-lining");
        System.out.printf("%-5d | %-25s%n", 5, "HotAir-Balloon Ride");
        System.out.printf("%-5d | %-25s%n", 6, "FoodTasting-Tour");
        System.out.printf("%-5d | %-25s%n", 7, "Historical-Sightseeing");
        System.out.printf("%-5d | %-25s%n", 8, "Beach-Camping");
        System.out.printf("%-5d | %-25s%n", 9, "Wildlife-Safari");
        System.out.printf("%-5d | %-25s%n", 10, "Photography-Walk");
        System.out.println("--------------------------------");
    }
}
