import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in); // scanner to gather user input
        System.out.println("Enter up to a maximum of 5 floating point numbers");
        var index = 0; // used to keep track of number of entries to end while loop once 5 is reached and add values to array
        float total = 0; // used to keep track of the total of all entered floating point numbers
        float[] values = new float[5]; // add all gathered values into a list to loop through and find min/max values

        while (index < 5) {
            try {
                System.out.println("Please enter floating point number " + (index + 1) + ": ");
                float number = scanner.nextFloat(); // captures user input as a float;
                values[index] = number; // assigns input to correct location in values array
                total += number; // adds to the existing total
                index++; // increments index for while loop control
            }
            catch (InputMismatchException e) { // catches specifically if the user did not enter a valid floating point number to notify them of that reason
                System.out.println("Error: " + e);
                System.out.println("Please enter a valid floating point number");
                scanner.next(); // have to explicitly tell the scanner to go to next line so it doesn't keep invalid input and cause infinite loop
            } catch (Exception e) { // catches all other exceptions to not disrupt flow and allow user to try again
                System.out.println("Error: " + e);
                System.out.println("Please try again");
                scanner.next();
            }
        }

        System.out.println("|Total         | " + total);
        System.out.println("|Average       | " + total/index);
        System.out.println("|Maximum       | " + String.format("%.2f", GetMaxValue(values)));
        System.out.println("|Minimum       | " + String.format("%.2f", GetMinValue(values)));
        System.out.println("|Interest(20%) | " + String.format("%.2f", total * 0.2));
    }

    // utilizes the array of floating point values to loop through and find the maximum entered value
    private static float GetMaxValue(float[] values) {
        var max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        return max;
    }

    // utilizes the array of floating point values to loop through and find the minimum entered value
    private static float GetMinValue(float[] values) {
        var min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }

        return min;
    }
}