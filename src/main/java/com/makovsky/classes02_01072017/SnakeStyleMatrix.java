package com.makovsky.classes02_01072017;

import java.util.Arrays;

/**
 * Class SnakeStyleMatrix fills matrix in snake style
 */
public class SnakeStyleMatrix {

    /**
     * Main method
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        printMatrix(snakeArrayFill(10, 10, true));
        long endTime = System.currentTimeMillis();
        System.out.println("Program done in: " + (endTime - startTime) + " ms.");
    }

    /**
     * Method snakeArrayFill fills matrix in snake style
     *
     * @param first  capacity of first array
     * @param second capacity of second array
     * @return snake style filled matrix
     */
    public static int[][] snakeArrayFill(int first, int second, boolean isPositive) {
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
                matrix[x][y] = signAlter(counter, isPositive);
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
                matrix[x][y] = signAlter(counter, isPositive);
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
                matrix[x][y] = signAlter(counter, isPositive);
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
                matrix[x][y] = signAlter(counter, isPositive);
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
     * @param matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * Method signAlter change sign of number
     *
     * @param count      current value of counter
     * @param isPositive true if you want positive number, false if negative
     * @return positive or negative value
     */
    public static int signAlter(int count, boolean isPositive) {
        if (!isPositive) {
            String string = "-" + String.valueOf(count);
            return Integer.parseInt(string);
        } else return count;
    }
}