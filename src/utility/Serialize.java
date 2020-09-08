package utility;

import model.Activity;

import java.io.*;
import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class Serialize {
//    ArrayList<Activity> actList=new ArrayList <>();

    public void serialize(ArrayList<Activity> actList){

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Serialization▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        try{
//            System.out.println(System.getProperty("user.dir"));
            FileOutputStream fileOut= new FileOutputStream("src/resources/activity.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(actList);

            out.close();
            fileOut.close();
            System.out.println("Serialized stuff saved in /activity.ser");

        }catch (IOException i){
            i.printStackTrace();
        }
    }


    public ArrayList<Activity> deserialize(){
        ArrayList<Activity> actList=new ArrayList<>();
        //model.Activity act=null;
        try{
//            System.out.println(System.getProperty("user.dir"));
            FileInputStream fileIn= new FileInputStream("src/resources/activity.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
             actList = (ArrayList<Activity>) in.readObject();
            //ArrayList<model.Activity> actListFromFile = (ArrayList<model.Activity>) in.readObject();
            //actList .add(act);
            //actList = actListFromFile;
            //act=(model.Activity) in.readObject();
            //actList.add(act);
            in.close();
            fileIn.close();
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        catch(IOException i){
            i.printStackTrace();
        }
        return actList;
    }
}
