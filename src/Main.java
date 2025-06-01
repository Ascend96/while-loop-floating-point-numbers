import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter up to a maximum of 5 floating point numbers");
        var index = 0;
        float total = 0;
        float[] values = new float[5];

        while (index < 5) {
            try {
                System.out.println("Please enter floating point number " + (index + 1) + ": ");
                float number = scanner.nextFloat();
                values[index] = number;
                total += number;
                index++;
            }
            catch (InputMismatchException e) {
                System.out.println("Error: " + e);
                System.out.println("Please enter a valid floating point number");
                scanner.next();
            } catch (Exception e) {
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

    private static float GetMaxValue(float[] values) {
        var max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        return max;
    }

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