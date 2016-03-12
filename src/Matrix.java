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

    public int determinant() {
        return 0;
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

    private void sameSizeCheck(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrices must be the same size");
        }
    }
}
