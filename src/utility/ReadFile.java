package utility; /**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Feb 2020
 */
import model.Activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {
    //private ActivityList activityList;
    //private ActivityList activityList;

    public void readFile(String filename,ArrayList<Activity> actList) {
        try {
            File f = new File(filename);
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                //read first line and process it
                String inputLine = scanner.nextLine();
                if (inputLine.length() != 0) {//ignored if blank line
                    processLine(inputLine,actList);
                }
            }
        }
        //if the file is not found, stop with system exit
        catch (FileNotFoundException fnf){
            System.out.println( filename + " not found ");
            System.exit(0);
        }
    }

    /**
     * Processes line, extracts data, creates object
     * and adds to list
     * Checks for non-numeric year and missing items
     * Will still crash if name entered without a space
     * @param line the line to be processed
     */
    private void processLine(String line,ArrayList<Activity> actList) {
        try {
            String parts [] = line.split(",");
            //model.Activity act = new model.Activity();

            String activity=parts[0];
            int points= Integer.parseInt(parts[1]);
            LocalDate userDate=LocalDate.parse(parts[2]);
            String week=parts[3];


            //create an model.Activity object and add to the list
            Activity a=new Activity();
            a.setActivity(activity);
            a.setWeek(week);
            a.setPoints(points);
            a.setUserDate(userDate);

            //this.add(a);
            System.out.println(a);
            actList.add(a);

        }
        //for these two formatting errors, ignore lines in error and try and carry on
        //this catches trying to convert a String to an integer
        // if used  ………………….
        catch (NumberFormatException nfe) {
            String error = "Number conversion error in '" + line + "'  - "
                    + nfe.getMessage();
            System.out.println(error);
        }
        //this catches missing items if only one or two items
        //other omissions will result in other errors
        catch (ArrayIndexOutOfBoundsException air) {
            String error = "Not enough items in  : '" + line
                    + "' index position : " + air.getMessage();
            System.out.println(error);
        }

    }


//    public static void printArrayListToFile(ArrayList<model.Activity> actList){
//        File fileName= new File("./src/activities.txt");
//
//        try{
//            FileWriter fw= new FileWriter(fileName);
//            BufferedWriter output=new BufferedWriter(fw);
//
//            for(int i = 0; i < actList.size(); i++) {
//                model.Activity act=actList.get(i);
//                output.write(act.toFile()+"\n");
//            }
//            output.close();
//            fw.close();
//
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "Cannot create file");
//        }
//    }

}
