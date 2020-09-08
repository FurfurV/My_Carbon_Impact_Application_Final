package test;

import static org.junit.Assert.*;
import org.junit.*;

import controller.ManagementController;
import model.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class ManagementControllerTest {

//    public static void testAddActivity(){
//        assertEquals( testActList,ManagementController.addActivity(testActList,"week","activity",LocalDate.now(),5));
//    }
    @Test
    public void testAddPoints() {
        ArrayList<Activity> testAct = new ArrayList<>();
        ArrayList<Activity> testAct2=new ArrayList<>();
        Activity act=new Activity();
        Activity act2=new Activity();
        Activity act3=new Activity();

        act.setActivity("activity");
        act.setWeek("week");
        act.setPoints(1);
        act.setUserDate(LocalDate.now());

        act2.setActivity("activity");
        act2.setWeek("week");
        act2.setPoints(5);
        act2.setUserDate(LocalDate.now());

        act3.setActivity("activity");
        act3.setWeek("week");
        act3.setPoints(-9);
        act3.setUserDate(LocalDate.now());

        testAct.add(0,act);
        testAct.add(1,act2);

        testAct2.add(0,act);
        testAct2.add(1,act2);
        testAct2.add(2,act3);

        assertEquals(6,ManagementController.addPoints(testAct));
        assertEquals(-3,ManagementController.addPoints(testAct2));
        assertNotEquals(2,ManagementController.addPoints(testAct2));

    }

    @Test
    public void testRemove(){
        ArrayList<Activity> testAct = new ArrayList<>();
        ArrayList<Activity> testAct2=new ArrayList<>();
        ArrayList<Activity> testAct3=new ArrayList<>();

        Activity act=new Activity();
        Activity act2=new Activity();
        Activity act3=new Activity();

        act.setActivity("activity");
        act.setWeek("week");
        act.setPoints(1);
        act.setUserDate(LocalDate.now());

        act2.setActivity("activity");
        act2.setWeek("week");
        act2.setPoints(5);
        act2.setUserDate(LocalDate.now());

        testAct.add(0,act);
        testAct.add(1,act2);

        testAct2.add(0,act);
        testAct2.add(1,act2);
        testAct2.add(2,act3);

        ManagementController.removeAct(2,testAct2);

        assertEquals(testAct,testAct2);
        assertNotEquals(testAct,testAct3);
    }

    @Test
    public void testAddAct(){
        ArrayList<Activity> testAct = new ArrayList<>();
        ArrayList<Activity> testAct2=new ArrayList<>();
        ArrayList<Activity> testAct3=new ArrayList<>();

        Activity act=new Activity();
        Activity act2=new Activity();

        act.setActivity("activity");
        act.setWeek("week");
        act.setPoints(1);
        act.setUserDate(LocalDate.now());

        act2.setActivity("act");
        act2.setWeek("week2");
        act2.setPoints(5);
        act2.setUserDate(LocalDate.now());

        testAct.add(0,act);
        testAct.add(1,act2);

        ManagementController.addActivity(testAct2,"week","activity",LocalDate.now(),"1");
        ManagementController.addActivity(testAct2,"week2","act",LocalDate.now(),"5");

        assertEquals(testAct.toString(),testAct2.toString());
        assertNotEquals(testAct,testAct3);
    }

}
