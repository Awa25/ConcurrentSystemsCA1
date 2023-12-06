package csvmatrix;

import java.util.ArrayList;


public class MatrixMultiplication {

    // Declare two 2D arrays of size 10x10
    private final int[][] matrix1 = new int[10][10];
    private final int[][] matrix2 = new int[10][10];

    /**
     * A method to populate the two matrices from a CSV file
     */
    public void twoMatrices(){
        
        // Create an object of the ReadCSV class
        ReadCSV csvReader = new ReadCSV();
        
        // Call the readCSV method of the ReadCSV class and store the returned values in an ArrayList
        ArrayList<Integer> valuesFromCSV = csvReader.readCSV();

        // Declare an index variable to keep track of the ArrayList index
        int index = 0;
        
        // Populate the first matrix from the ArrayList
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10 ; col++) {
                matrix1[row][col] = valuesFromCSV.get(index++);
            }
        }
        
        // Populate the second matrix from the ArrayList
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10 ; col++) {
                matrix2[row][col] = valuesFromCSV.get(index++);
            }
        }
    }

    /**
     * A method to multiply two matrices
     */
    public void multiplyAllMatrices() {
        
        // Populate the two matrices from csv file
        twoMatrices();

        // Create two Matrix objects using the two matrices
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);

        // Print the two matrices
        m1.printMatrix();
        m2.printMatrix();

        // Multiply the two matrices and store the result in another Matrix object
        Matrix resultMatrix = m1.multiplyMatrix(m2);

        // Print the result matrix
        System.out.println("Result Matrix for the following data:");
        resultMatrix.printMatrix();
    }
}