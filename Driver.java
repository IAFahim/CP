public class Driver {
    public static void main(String[] args) {

        Matrix matrix1 = Matrix.generateRandomMatrix(3, 3);
        Matrix matrix2 = Matrix.generateRandomMatrix(3, 7, 6.0, 79.5);
        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());
        Matrix matrix3 = matrix1.multiplyMatrixByConstant(6);
        Matrix matrix4 = matrix2.multiplyMatrixByConstant(9);

    }
}