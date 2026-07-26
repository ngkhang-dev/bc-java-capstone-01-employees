package util;

import java.util.Scanner;

public final class InputHelper {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Enter a string
     *
     * @param msg
     * @return The string entered by the user or null if the user presses Enter
     */
    public static String readLine(String msg) {
        System.out.printf("%s: ", msg);
        return sc.nextLine().trim();
    }

    /**
     * Enter a string and check if it is empty
     *
     * @param msg
     * @param fieldName The label of the field
     * @return The string entered by the user
     */
    public static String readLine(String msg, String fieldName) {
        while (true) {
            String input = readLine(msg);

            if (!input.isEmpty()) {
                return input;
            }

            System.out.printf("%s is required\n", fieldName);
        }
    }

    /**
     * Enter an integer
     *
     * @param msg
     * @param fieldName The label of the field
     * @return The integer entered by the user
     */
    public static int readInt(String msg, String fieldName) {
        while (true) {
            try {
                System.out.printf("%s: ", msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.printf("%s is must be a integer\n", fieldName);
            }
        }
    }

    /**
     * Enter an integer and check if it is within the specified range
     *
     * @param msg
     * @param min
     * @param max
     * @param fieldName The label of the field
     * @return The integer entered by the user
     */
    public static int readInt(String msg, int min, int max, String fieldName) {
        while (true) {
            int input = readInt(msg, fieldName);

            if (input >= min && input <= max) {
                return input;
            }

            System.out.printf("%s is must be in range %d to %d\n", fieldName, min, max);
        }
    }

    /**
     * Enter a double
     *
     * @param msg
     * @param fieldName The label of the field
     * @return The double entered by the user
     */
    public static double readDouble(String msg, String fieldName) {
        while (true) {
            try {
                System.out.printf("%s: ", msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.printf("%s is must be a number\n", fieldName);
            }
        }
    }

    /**
     * Enter a double and check if it is within the specified range
     *
     * @param message
     * @param min
     * @param max
     * @param fieldName The label of the field
     * @return The double entered by the user
     */
    public static double readDouble(String message, double min, double max, String fieldName) {
        while (true) {
            double input = readDouble(message, fieldName);

            if (input >= min && input <= max) {
                return input;
            }

            System.out.printf("%s is must be in range %.2f to %.2f\n", fieldName, min, max);
        }
    }
}
