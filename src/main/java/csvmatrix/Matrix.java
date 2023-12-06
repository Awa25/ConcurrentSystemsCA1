package csvmatrix;

// This is the definition of the Matrix class
public class Matrix {
    
    // These are the private instance variables of the Matrix class
    private final int rows;
    private final int cols;
    private final int array[][];

    // This is a constructor that initializes the instance variables with a 2D array
    public Matrix(int array[][]) {
    this.array = array;
    this.rows = array.length;
    this.cols = array[0].length;
    }

    // This is a constructor that initializes the instance variables with given row and column numbers
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        array = new int[rows][cols];
    }

    // This method returns the number of rows in the matrix
    public int getMatrixRows() {
        return this.rows;
    }

    // This method returns the number of columns in the matrix
    public int getMatrixCols() {
        return this.cols;
    }

    // This method sets the value of an element in the matrix
    public void setValue(int rows, int cols, int value) {
        array[rows][cols] = value;
    }



    // This method prints the matrix to the console
    public void printMatrix() {        
        int row = 0;   
        while (row < getMatrixRows()) {           
            System.out.print("[");           
            int col = 0;            
            while (col < getMatrixCols()) {               
                System.out.printf("% 5d", array[row][col]);                
                col += 1;
            }            
            System.out.println("]");
            row += 1;
        }        
        System.out.println();
    }


    // This method multiplies two matrices and returns the resulting matrix
    public Matrix multiplyMatrix(Matrix matrixB) {
        
        // Check if the matrices can be multiplied
        if(this.cols == matrixB.getMatrixRows()) {
            
            // Create a new matrix to store the result
            Matrix matrixC = new Matrix(this.rows, matrixB.getMatrixCols());
            
            // Perform matrix multiplication
            for (int row = 0; row < this.rows; row += 1) {
                for (int col = 0; col < matrixB.getMatrixCols(); col += 1) {
                    int sum = 0;
                    for (int k = 0; k < this.cols; k += 1) {
                        sum += (this.array[row][k] * array[k][col]);
                    }                    
                    matrixC.setValue(row, col, sum);
                }
            }            
            // Return the resulting matrix
            return matrixC;
        }
        
        else {
            // return null if cannot be multiplied
            return null;
        }
    }   
}