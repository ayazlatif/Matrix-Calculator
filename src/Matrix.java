import java.util.*;

/**
 * Created by AyazLatif on 3/12/16.
 */
public class Matrix {
    int cols;
    int rows;
    int[][] data;

    public Matrix(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        data = new int[cols][rows];
    }

    public Matrix(int[][] data) {
        this.cols = data[0].length;
        this.rows = data.length;
        this.data = data;
    }

    public int[] getRow(int i) {
        return data[i];
    }

    public int[] getColumn(int j) {
        int[] column = new int[cols];
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
        if(rows != other.rows && cols != other.cols) {
            throw new IllegalArgumentException("In order for matrices to add, they must be the same size");
        }
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                data[i][j] += other.data[i][j];
            }
        }
    }

    public String toString() {
        String result = "";
        for(int[] column : data) {
            result = result + Arrays.toString(column) + "\n";
        }
        return result;
    }
}
