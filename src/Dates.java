/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ritwika
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Dates {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.out.println("Hi");
        File dir = new File("Files/nwc");
        File[] directoryListing = dir.listFiles();
        FileWriter file = new FileWriter("matches.txt");
        BufferedWriter filewriter = new BufferedWriter(file);
        System.out.println(directoryListing.length);
        Scanner in;
        String line,year,data = null,date;
        int yr;
        ArrayList<ArrayList<String>> matches = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 13; i++) {
            matches.add(new ArrayList<String>());
        }
        if(directoryListing != null){
            for(File child: directoryListing){
                in = new Scanner(child);
                data ="";
                line = in.nextLine();
                line = in.nextLine();
                date = line; 
                year = line.split("-")[0];
                yr = Integer.parseInt(year);
                line = in.nextLine();line = in.nextLine();line = in.nextLine();
                data = date + "," + line + ","; data+=in.nextLine() + "," + (child.getName().split(".txt")[0]);
                matches.get(yr-2005).add(data);
                in.close(); 
            }
        }
        
        for(int i=0;i<matches.size();i++){
            for (int j = 0; j <matches.get(i).size(); j++) {
                filewriter.write(matches.get(i).get(j)+"\n");
            }
        }
        filewriter.close();
//        for (int i = 0; i < matches.size(); i++) {
//            ArrayList<String> get = matches.get(i);
//             for (int j = 0; j < get.size(); i++) {
//                data = get.get(j);
//                filewriter.write(data+"\n");
//             }
//        }
//       filewriter.close();
    }
    
}
