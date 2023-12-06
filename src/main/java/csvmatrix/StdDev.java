package csvmatrix;


import java.util.ArrayList;


public class StdDev {

   // A method to calculate and print the standard deviation of data in a CSV file
   public void stdDev() {
       
        // Create an object of the ReadCSV class
        ReadCSV readCSV = new ReadCSV();
        
        // Read the CSV data into an ArrayList
        ArrayList<Integer> data = readCSV.readCSV();
        
        double sum = 0.0;
        
        // Calculate the sum of the data
        for (int i = 0; i < data.size(); i++) {
            double d = data.get(i);
            sum = sum + d;
        }
        
        // Calculate the mean
        double mean = sum / data.size();
        
        // Calculate variance
        double variance = 0.0;
        for (int i = 0; i < data.size(); i++) {
            double d = data.get(i);
            variance = variance + Math.pow(d - mean, 2);
        }
        variance = variance / data.size();
        
        // Calculate standard deviation
        double stdDeviation = Math.sqrt(variance);
        
        // Print the standard deviation
        System.out.println("The Standard Deviation for the following data is: " + stdDeviation);
    }
}