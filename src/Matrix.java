import java.util.*;

/**
 * Created by AyazLatif on 3/12/16.
 */
public class Matrix {
    int cols;
    int rows;
    double[][] data;

    public Matrix(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        data = new double[cols][rows];
    }

    public Matrix(double[][] data) {
        this.cols = data[0].length;
        this.rows = data.length;
        this.data = data;
    }

    public double[] getRow(int i) {
        return data[i];
    }

    public double[] getColumn(int j) {
        double[] column = new double[cols];
        for(int i = 0; i < cols; i++) {
            column[i] = data[i][j];
        }
        return column;
    }

    public boolean isSquare() {
        return rows == cols;
    }

    public double determinant() {
    	if(!isSquare()) {
    		throw new IllegalArgumentException("Matrix must be a square");
    	}
        return determinant(this.rows, data);
    }
    
    private double determinant(int n, double[][] minor) {
    	//System.out.println("At start of method\n" + toString(minor));
    	if(n == 1) {
    		return minor[0][0];
    	} else if (n == 2) {
    		//System.out.println("det with n = 2 is :" + (minor[0][0] * minor[1][1] - minor[0][1] * minor[1][0]));
    		return minor[0][0] * minor[1][1] - minor[0][1] * minor[1][0];
    	} else {
    		double determinant = 0;
    		//System.out.println("Before for loop\n" + toString(minor));
    		for(int i = 0; i < n; i++) {
    			double[][] nextMinor = new double[n - 1][n - 1];
    			int index = 0;
    			for(int j = 0; j < n; j++) {
    				if(j != i) {
    					nextMinor[index] = getSubRow(j, n - 1, minor);
    					index++;
    				}
    			}
    			//System.out.println("Note: data[i][0] " + minor[i][0] * Math.pow(-1, i) + " This is the " + i + " minor\n" + toString(nextMinor));
    			determinant = determinant + ((minor[i][0] * Math.pow(-1, i)) *
    					determinant(n - 1, nextMinor));
    		}
    		return determinant;
    	}
    }
    
    private double[] getSubRow(int j, int n, double[][] minor) {
    	double[] subRow = new double[n];
    	int index = 0;
    	for(int i = 1; i < minor.length; i++) {
    			subRow[index] = minor[j][i];
    			index++;
    	}
    	return subRow;
    }

    public void add(Matrix other) {
        sameSizeCheck(other);
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                data[i][j] += other.data[i][j];
            }
        }
    }

    public void subtract(Matrix other) {
        sameSizeCheck(other);
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                data[i][j] -= other.data[i][j];
            }
        }
    }

    public Matrix multiply(Matrix other) {
        if(cols != other.rows) {
            throw new IllegalArgumentException("Incorrect matrix sizes");
        }
        double[][] data = new double[rows][other.cols];
        // TODO: actually mutiply matrix
        return new Matrix(data);
    }

    public String toString() {
        String result = "";
        for(double[] column : data) {
            result = result + Arrays.toString(column) + "\n";
        }
        return result;
    }
    
    public String toString(double[][] data) {
        String result = "";
        for(double[] column : data) {
            result = result + Arrays.toString(column) + "\n";
        }
        return result;
    }

    private void sameSizeCheck(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrices must be the same size");
        }
    }
}
