package a30_03_averageCalculator;

public class AverageCalculator {

    public static void main(String[] args) {
        AverageCalculator calc = new AverageCalculator();

        // Array null
        double[] arrayNull = null;

        // Array empty
        double[] emptyArray = new double[]{};

        // Array with negatives
        double[] arrayWithNegatives = new double[]{10.0, -5.0, 20.0, 30.0, 40.0};

        // Array with correct data
        double[] arrayCorrect = new double[]{12.0, 11.5, 11.7, 15.8, 13.7, 13.2};

        try {
            System.out.println("Array null:");
            System.out.println(calc.averageCalculator(arrayNull));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Array empty:");
            System.out.println(calc.averageCalculator(emptyArray));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Array with negatives:");
            System.out.println(calc.averageCalculator(arrayWithNegatives));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Array with correct data:");
        System.out.println(calc.averageCalculator(arrayCorrect));
    }

    public double averageCalculator(double[] values) {
        if (values == null)
            throw new NullPointerException("Array can't be null.");

        if (values.length == 0)
            throw new ArithmeticException("Array can't be empty.");

        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0)
                throw new IllegalArgumentException("Value can't be negative.");
            sum += values[i];
        }
        return sum / values.length;
    }
}