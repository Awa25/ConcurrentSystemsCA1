package csvmatrix;

import java.io.FileNotFoundException;


public class CsvMatrix {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Read CSV file:");
        MatrixMultiplication matrix = new MatrixMultiplication();
        matrix.multiplyAllMatrices();
        StdDev obj = new StdDev();
        obj.stdDev();
        System.out.println();
        MergeSort sort = new MergeSort();
        sort.mergeAndSort();
    }
}
