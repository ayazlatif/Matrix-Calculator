/**
 * Created by AyazLatif on 3/12/16.
 */
public class MatrixClient {

    public static void main(String[] args) {
        double[][] a1 = {{1, 2, 3},
                {3, 4, 5}};
        double[][] a2 = {{1},
                {1},
        		{2}};
        Matrix m1 = new Matrix(a1);
        Matrix m2 = new Matrix(a2);
        System.out.println(m1);
        //m1.add(m2);
        System.out.println();
        System.out.println(m1);
        Matrix m3 = m1.multiply(m2);
        System.out.println(m3);

    }


}
