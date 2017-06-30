package classes02_01072017;

import java.util.Arrays;

/**
 * Class SnakeStyleMatrix fills matrix in snake style
 */
public class SnakeStyleMatrix {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        printMatrix(snakeArrayFill(10, 10));
    }

    /**
     * Method snakeArrayFill fills matrix in snake style
     *
     * @param first  capacity of first array
     * @param second capacity of second array
     * @return snake style filled matrix
     */
    public static int[][] snakeArrayFill(int first, int second) {
        int[][] matrix = new int[first][second];
        int counter = 1;
        int x = 0;
        int y = 0;

        while (counter < (first * second + 1)) {
            while (y <= second - 1) {
                if (matrix[x][y] != 0) {
                    x++;
                    y--;
                    break;
                }
                matrix[x][y] = counter;
                counter++;
                if (y != second - 1) y++;
                else {
                    x++;
                    break;
                }
            }

            while (x <= first - 1) {
                if (matrix[x][y] != 0) {
                    x--;
                    y--;
                    break;
                }
                matrix[x][y] = counter;
                counter++;
                if (x != first - 1) x++;
                else {
                    y--;
                    break;
                }
            }

            while (y >= 0) {
                if (matrix[x][y] != 0) {
                    x--;
                    y++;
                    break;
                }
                matrix[x][y] = counter;
                counter++;
                if (y != 0) y--;
                else {
                    x--;
                    break;
                }
            }

            while (x >= 0) {
                if (matrix[x][y] != 0) {
                    x++;
                    y++;
                    break;
                }
                matrix[x][y] = counter;
                counter++;
                if (x != 0) x--;
                else {
                    y++;
                    break;
                }
            }
        }
        return matrix;
    }

    /**
     * This method prints matrix in console
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}