package classes02_01072017;

import java.util.Scanner;

/**
 * This class calculate did dot with coordinates X and Y is laying between parabola and circle with radius RADIUS
 */
public class DotInCircleAndParabola {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter X:");
        float x = scanner.nextFloat();

        System.out.println("Please, enter Y:");
        float y = scanner.nextFloat();

        System.out.println("Please, enter RADIUS:");
        float radius = scanner.nextFloat();

        if (checkInParabola(x, y) && checkInCircle(x, y, radius)) {
            System.out.println("This dot is laying between parabola and circle with radius " + radius);
        } else System.out.println("This dot isn't laying between parabola and circle with radius " + radius);
    }

    /**
     * This class calculate did dot with coordinates X and Y is laying in parabola
     *
     * @param x coordinate
     * @param y coordinate
     * @return true/false
     */
    public static boolean checkInParabola(double x, double y) {
        return y >= (x * x);
    }

    /**
     * This class calculate did dot with coordinates X and Y is laying in circle
     *
     * @param x coordinate
     * @param y coordinate
     * @param radius of circle
     * @return
     */
    public static boolean checkInCircle(double x, double y, double radius) {
        return (x * x + y * y) <= (radius * radius);
    }
}
