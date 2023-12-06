package csvmatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {

    // A method to read data from a CSV file and return an ArrayList of integers
    public ArrayList<Integer> readCSV(){

        // CSV file name
        String csvFile = "data.csv";
        
        // Empty string to hold each line of CSV data
        String line = "";
        
        // Delimiter used in the CSV file
        String csvSplitBy = ",";
        
        // ArrayList to hold the integers from the CSV file
        ArrayList<Integer> list = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Loop through each line in the CSV file
            do {
                line = br.readLine();
                if (line != null) {
                    String[] data = line.split(csvSplitBy);
                    for (int i = 0; i < data.length; i++) {
                        String d = data[i];
                        list.add(Integer.valueOf(d));
                    }
                }
            } 
            while (line != null);
        } 
        
        catch (IOException e) {
            // Print stack trace if there is an IOException
            e.printStackTrace();
        }

        // Return the ArrayList of integers from the CSV file
        return list;
    }
}