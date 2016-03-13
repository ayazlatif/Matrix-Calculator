import java.util.*;

/**
 * Created by AyazLatif on 3/12/16.
 * 
 */
public class Matrix {
    private final int COLS;
    private final int ROWS;
    private final double DETERMINANT;
    private final double[][] DATA;

    /**
     * @param int rows represents number of rows in a matrix
     * @param int cols represents number of columns in a matrix
     * Constructs a matrix object with given number of rows and columns
     */
    public Matrix(int rows, int cols) {
        this(new double[cols][rows]);
    }

    /**
     * @param 2-d data array that represents a matrix
     * Constructs a matrix object with given data
     */
    public Matrix(double[][] data) {
        this.COLS = data[0].length;
        this.ROWS = data.length;
        this.DATA = data;
        if(this.isSquare()) {
        	this.DETERMINANT = computeDeterminant(data);
        } else {
        	this.DETERMINANT = 0;
        }
    }

    /**
     * @param int i is a row number
     * @return a row from matrix as a double array with given row number 
     */
    public double[] getRow(int i) {
        return DATA[i];
    }

    /**
     * @param int j is a column number
     * @return a column form a matrix as a double array with a given column number
     */
    public double[] getColumn(int j) {
        double[] column = new double[ROWS];
        for(int i = 0; i < ROWS; i++) {
            column[i] = DATA[i][j];
        }
        return column;
    }

    /**
     * @return true if a matrix is square
     */
    public boolean isSquare() {
        return ROWS == COLS;
    }

    /**
     * Pre: Matrix is square otherwise throws an IllegalState Exception
     * Post: Returns determinant of matrix
     * @return double value determinant
     */
    public double getDeterminant() {
    	if(!isSquare()) {
    		throw new IllegalStateException("Matrix must be a square");
    	}
        return DETERMINANT;
    }
    
    /**
     * Returns determinant of matrix
     * @param minor matrix
     * @return double value determinant
     */
    private double computeDeterminant(double[][] minor) {
    	int n = minor.length;
    	if(n == 1) { // minor/matrix of size 1
    		return minor[0][0];
    	} else if (n == 2) {
    		return minor[0][0] * minor[1][1] - minor[0][1] * minor[1][0];
    	} else { // recursive case
    		double determinant = 0;
    		for(int i = 0; i < n; i++) {
    			double[][] nextMinor = new double[n - 1][n - 1];
    			int index = 0;
    			for(int j = 0; j < n; j++) {
    				if(j != i) { // To exclude current column of minor
    					nextMinor[index] = getSubRow(j, n - 1, minor);
    					index++;
    				}
    			}
    			determinant = determinant + ((minor[i][0] * Math.pow(-1, i)) *
    					computeDeterminant(nextMinor));
    		}
    		return determinant;
    	}
    }
    
    /**
     * @param j column number
     * @param n size of sub row
     * @param minor matrix
     * @return double array of part of a row (excluding jth column)
     */
    private double[] getSubRow(int j, int n, double[][] minor) {
    	double[] subRow = new double[n];
    	int index = 0;
    	for(int i = 1; i < minor.length; i++) {
    			subRow[index] = minor[j][i];
    			index++;
    	}
    	return subRow;
    }

    /**
     * @param other Matrix
     * @return sum of two matrices
     */
    public Matrix add(Matrix other) {
        sameSizeCheck(other);
        double[][] addData = copyData();
        for(int i = 0; i < COLS; i++) {
            for(int j = 0; j < ROWS; j++) {
                addData[i][j] += other.DATA[i][j];
            }
        }
        return new Matrix(addData);
    }

    /**
     * @param other Matrix
     * @return difference of two matrices
     */
    public Matrix subtract(Matrix other) {
        sameSizeCheck(other);
        double[][] subtractData = copyData();
        for(int i = 0; i < COLS; i++) {
            for(int j = 0; j < ROWS; j++) {
                subtractData[i][j] -= other.DATA[i][j];
            }
        }
        return new Matrix(subtractData);
    }

    /**
     * @param other matrix
     * @return product of two matrices
     */
    public Matrix multiply(Matrix other) {
        if(COLS != other.ROWS) {
            throw new IllegalArgumentException("Incorrect matrix sizes");
        }
        double[][] multipliedMatrix = new double[ROWS][other.COLS];
        for(int i = 0; i < ROWS; i++) {
        	for(int j = 0; j < other.COLS; j++) {
        		multipliedMatrix[i][j] = multiply(other, i, j);
        	}
        }
        return new Matrix(multipliedMatrix);
    }
    
    /**
     * @param other Matrix
     * @param i row
     * @param j column
     * @return product of single row and column of matrix
     */
    private double multiply(Matrix other, int i, int j) {
    	double[] row = getRow(i);
    	double[] column = other.getColumn(j);
    	double answer = 0;
    	for(int k = 0; k < row.length; k++) {
    		answer = answer + row[k] * column[k];
    	}
    	return answer;
    }
    
    /**
     * @return string representation of a matrix
     */
    public String toString() {
        return toString(DATA);
    }
    
    /**
     * @param: DATA (2 dimensional array)
     * @return string representation of 2-D array
     * Can be helpful for debugging
     */
    private String toString(double[][] DATA) {
        String result = "";
        for(double[] column : DATA) {
            result = result + Arrays.toString(column) + "\n";
        }
        return result;
    }

    /**
     * Checks if current matrix is the same size as other matrix
     * If not same size throws IllegalArgumentException
     * @param other matrix
     */
    private void sameSizeCheck(Matrix other) {
        if (ROWS != other.ROWS || COLS != other.COLS) {
            throw new IllegalArgumentException("Matrices must be the same size");
        }
    }
    
    /**
     * @return copy of matrix
     */
    private double[][] copyData() {
    	double[][] copyData = new double[COLS][ROWS];
    	for(int i = 0; i < COLS; i++) {
    		for(int j = 0; j < ROWS; j++) {
    			copyData[i][j] = DATA[i][j];
    		}
    	}
    	return copyData;
    }
}
