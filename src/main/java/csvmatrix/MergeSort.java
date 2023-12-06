package csvmatrix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

// Define MergeDescending class
public class MergeSort {
    
    // Define method to perform merge sort
    public void mergeAndSort() throws FileNotFoundException {
        
        // Read the CSV file
        ReadCSV readCSV = new ReadCSV();
        ArrayList<Integer> list = readCSV.readCSV();


        // Convert the ArrayList to an array
        int[] arr = new int[list.size()];
        int i = 0;
        
        do {
            arr[i] = list.get(i);
            i++;
        } 
        while (i < arr.length);

        
        // Array before sorting
        System.out.println("Data Before Sorting: " + Arrays.toString(arr) + "\n");

        // Call mergeSortDescending method to sort the array
        mergeSortInDescending(arr, 0, arr.length - 1);

        // Array after sorting
        System.out.println("Data After Sorting: " + Arrays.toString(arr));
    }

    
    // Define method to perform merge sort in descending order
    public static void mergeSortInDescending(int[] arr, int l, int r) {
        
        // Check if left index is less than right index
        if (l < r) {
            // Calculate the middle index
            int m = (l + r) / 2;

            // Recursively call mergeSortDescending for the left and right halves of the array
            mergeSortInDescending(arr, l, m);
            mergeSortInDescending(arr, m + 1, r);

            // Call mergeDescending method to merge the two halves of the array
            mergeInDescending(arr, l, m, r);
        }
    }

    
    // Define method to merge the two halves of the array in descending order
    public static void mergeInDescending(int[] arr, int l, int m, int r) {
        
        // Calculate the sizes of the two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary subarrays to store the left and right halves of the main array
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy the left half of the main array to the temporary subarray L
        int index = 0;
        do {
            L[index] = arr[l + index];
            index++;
        } 
        while (index < n1);

        // Copy the right half of the main array to the temporary subarray R
        int index2 = 0;
        do {
            R[index2] = arr[m + 1 + index2];
            index2++;
        } 
        while (index2 < n2);


        int i = 0, j = 0;
        int k = l;

        // Merge the two subarrays in descending order
        while (i < n1 && j < n2) {
            do {
                if (L[i] >= R[j]) {
                    arr[k] = L[i];
                    i++;
                } 
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            } 
            while (i < n1 && j < n2);
        }

        // Copy any remaining elements of the left subarray to the main array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of the right subarray to the main array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}