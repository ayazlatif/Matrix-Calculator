import java.util.Arrays;

/**
 * Created by AyazLatif on 3/12/16.
 */
public class MatrixClient {

    public static void main(String[] args) {
        double[][] a1 = {{1, 2, 3, 4},
                {5, 32, 7, 29},
                {6, 7, 2, 2},
                {2, 3, 6, 9}};
        double[][] a2 = {{2, 3},
                {3, 4},
        		{6, 2},
        		{2, 9}};
        double[][] a3 = {{2, 4},
        				{7, 9}};
        Matrix m1 = new Matrix(a1);
        Matrix m2 = new Matrix(a2);
        Matrix m3 = new Matrix(a3);
        Matrix m4 = m1.multiply(m2);
        System.out.println(m4);
       
    }


}
