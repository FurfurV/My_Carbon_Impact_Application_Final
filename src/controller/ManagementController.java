package controller;

import model.Activity;
import utility.Serialize;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class ManagementController {

    public static void addActivity(ArrayList<Activity> actList, String week, String activity, LocalDate date,String points){
        //points=(Int)points;
        int p;
        if(points==null){
            p=0;
        }else{
            p=Integer.parseInt(points);
        }

        if( p<-10 || p>10){
            System.out.println("Cant add, incorrect points!");
        } else{
            Activity act=new Activity();
            act.setWeek(week);
            act.setUserDate(date);
            act.setActivity(activity);
            act.setPoints(p);

            act.printData();
            actList.add(act);
        }
    }

    public static int addPoints(ArrayList<Activity> actList){
        int totalPoints=0;
        for(int i = 0; i < actList.size(); i++) {
            totalPoints+=actList.get(i).getPoints();
        }
        return totalPoints;
    }

    public static void removeAct(int index, ArrayList<Activity> actList){
        actList.remove(index);
    }

    public static void saveActiv(ArrayList<Activity> actList){
        Serialize serial=new Serialize();
        System.out.println(actList.toString());
        serial.serialize(actList);
    }

    public static ArrayList<Activity> loadActs(ArrayList<Activity> actList){
        Serialize serial = new Serialize();
        actList = serial.deserialize();
        System.out.println(actList.toString()+"deserialized");
        return actList;
    }
}
