package controller;

import model.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class Crasher {

    public static void crashApp(ArrayList<Activity> actList){
        System.out.println("oh no");
        String week="ouch";
        String activity="crash";
        LocalDate date=LocalDate.now();
        String points="-6";

        ManagementController.addActivity(actList,week,activity,date,points);
        System.out.println(actList.toString());
        crashApp(actList);
    }
}
