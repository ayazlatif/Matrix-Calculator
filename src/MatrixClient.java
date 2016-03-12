/**
 * Created by AyazLatif on 3/12/16.
 */
public class MatrixClient {

    public static void main(String[] args) {
        int[][] a1 = {{1, 2},
                {3, 4}};
        int[][] a2 = {{1, 1},
                {1, 1}};
        Matrix m1 = new Matrix(a1);
        Matrix m2 = new Matrix(a2);
        System.out.println(m1);
        m1.add(m2);
        System.out.println();
        System.out.println(m1);

    }


}
