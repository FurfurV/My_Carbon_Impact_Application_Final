package controller;

import model.Activity;
import utility.Serialize;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class ResultController {

    public static ArrayList<Activity> sortByPoints(ArrayList<Activity> actList,Serialize ser){
        ArrayList <Activity> a=new ArrayList<>();

            actList=ser.deserialize();
            System.out.println(actList.toString());

            if(actList==null || actList.size()==0){
                a= null;
            }else {

                for (int i = 0; i < actList.size(); i++) {
                    Collections.sort(actList,
                            (o1, o2) -> ((Integer)o1.getPoints()).compareTo(o2.getPoints()));

                    //listView.getItems().add(actList.get(i));
                    a.add(actList.get(i));
                }
            }
            return a;
    }

    public static ArrayList<Activity> sortByAct(ArrayList<Activity> actList,Serialize ser){
        ArrayList <Activity> a=new ArrayList<>();

        actList=ser.deserialize();
        System.out.println(actList.toString());

        if(actList==null || actList.size()==0){
            a= null;
        }else {

            for (int i = 0; i < actList.size(); i++) {
                Collections.sort(actList,
                        (o1, o2) -> o1.getActivity().compareTo(o2.getActivity()));

                a.add(actList.get(i));
            }
        }
        return a;
    }

    public static ArrayList<Activity> sortByDate(ArrayList<Activity> actList,Serialize ser){
        ArrayList <Activity> a=new ArrayList<>();

        actList=ser.deserialize();
        System.out.println(actList.toString());

        if(actList==null || actList.size()==0){
            a= null;
        }else {
            for (int i = 0; i < actList.size(); i++) {
                Collections.sort(actList,
                        (o1, o2) -> o1.getUserDate().compareTo(o2.getUserDate()));

                a.add(actList.get(i));
            }
        }
        return a;
    }


}
