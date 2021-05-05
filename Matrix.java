import java.util.Arrays;

public class Matrix {

    private int numberOfRows;
    private int numberOfColumns;
    private double[][] matrix;

    public Matrix(int constant, int rows, int columns) {
        this.numberOfRows = rows;
        this.numberOfColumns = columns;
        int[][] matrix1 = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = constant;
            }
        }
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.numberOfRows = matrix.length;
        this.numberOfColumns = matrix[0].length;
    }


    public int getNumberOfRows() {
        return numberOfRows;
    }


    public int getNumberOfColumns() {
        return numberOfColumns;
    }


    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }


    public static Matrix generateRandomMatrix(int rows, int columns) {
        double fill = (7.5) + (Math.random() * 34.5);
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = fill;
            }
        }
        return new Matrix(matrix);
    }

    public static Matrix generateRandomMatrix(int rows, int columns, double lowerBound, double upperBound) {

        double random = lowerBound + Math.random() * (upperBound - lowerBound);
        double[][] matrix;
        matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = random;
            }
        }
        return new Matrix(matrix);
    }

    public Matrix multiplyMatrixByConstant(int constant) {

        double[][] multiplyingMatrixByConstant = new double[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                multiplyingMatrixByConstant[i][j] = matrix[i][j] * constant;
            }
        }
        return new Matrix(multiplyingMatrixByConstant);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            sb.append('|');
            for (int j = 0; j < this.matrix[i].length; j++) {
                sb.append(this.matrix[i][j] + "|");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}