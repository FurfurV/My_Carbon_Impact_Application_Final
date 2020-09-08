package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 *
 * <h1> This class represents an activity</h1>
 * The activity model implemnts the serializable interface.
 * @author Viktoria Cseke
 * R00180598 Feb 2020
 * @version 1.2
 */

public class Activity implements Serializable {
    /**
     * A unique serial version identifier
     * @see Serializable
     */
    private static final long serialVersionUID = 4678782209391508288L;
    private String week;
    private LocalDate userDate;
    private String activity;
    private int points;

    /*
    * default constructor.
     */
    public Activity(){

    }

    /**
     * Creates an Activity with its description.
     * @param myWeek the week for the activity.
     * @param myUserDate the date for the activity.
     * @param myActivity the activity name.
     * @param myPoints the points for the activity.
     */

    public Activity(String myWeek, LocalDate myUserDate, String myActivity, int myPoints) {
        this.week=myWeek;
        this.userDate=myUserDate;
        this.activity=myActivity;
        this.points=myPoints;
    }

    /**
     * Gets the week for the activity
     * @return A string representing the week for the activity.
     */
    public String getWeek() {
        return week;
    }

    /**
     * Gets the date for the activity
     * @return A LocalDate representing the date for the activity in a year-month-day format.
     */
    public LocalDate getUserDate() {
        return userDate;
    }

    /**
     * Gets the activity name.
     * @return A string representing the name for the activity.
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Gets the points for the activity
     * @return An integer representing the points for the activity.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the week for the activity
     * @param week A string representing the week for the activity.
     */
    public void setWeek(String week) { this.week=week;
    }

    /**
     * Sets the date for the activity
     * @param userDate A LocalDate representing the date for the activity in a year-month-day format.
     */
    public void setUserDate(LocalDate userDate) {
        this.userDate = userDate;
    }

    /**
     * Sets the activity name.
     * @param activity a String representing the name for the activity.
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Sets the points for the activity
     * @param points An integer representing the points for the activity.
     */
    public void setPoints(int points) {
        this.points = points;
    }

//creates the string for the file
//    public String toFile(){
//        return activity+","+points+","+userDate+","+week;
//    }

    /**
     * Creates a formated string of the activity.
     * @return A string of the activity with its points, week and userdate.
     */
    @Override
    public String toString(){
        return activity+" "+points+" points, at: "+week+" "+userDate;
    }

    /**
     * A function that calls the toString method and prints a string.
     */
    public void printData(){
        System.out.println(toString());
    }

}
