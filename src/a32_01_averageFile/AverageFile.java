package a32_01_averageFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AverageFile {
    public static void main(String[] args) {
        final String FILE_PATH = "src/a32_01_averageFile/AverageFile.csv";
        try {
            double average = average(FILE_PATH);
            System.out.printf("Average: %.2f%n", average);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static double average(String file) throws IOException, FileNotFoundException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        input.readLine(); // ignora capçalera

        double markTotal = 0.0;
        int activeUsers = 0;

        while (true) {
            String line = input.readLine();
            if (line == null) break;

            String[] rows = line.split(";");
            boolean isActive = rows[3].equalsIgnoreCase("true");

            if (isActive) {
                double mark = Double.parseDouble(rows[2]);
                markTotal += mark;
                activeUsers += 1;
            }
        }

        input.close();
        return (activeUsers == 0) ? 0 : markTotal / activeUsers;
    }
}
