package a30_07_animeFilmsExceptions;

import java.io.*;
import java.util.Scanner;

public class AnimeFilms {
    public static void main(String[] args) {
        final AnimeFilms animeFilms = new AnimeFilms();
        final String INPUT_FILE = "src/a30_07_animeFilmsExceptions/animes.txt";
        final String OUTPUT_FILE = "src/a30_07_animeFilmsExceptions/output.txt";
        final String ERROR_FILE = "src/a30_07_animeFilmsExceptions/errors.txt";

        Scanner sc = new Scanner(System.in);

        System.out.println("Indica un any:");
        int year = sc.nextInt();

        try {
            String filteredAnimes = animeFilms.readTextFile(INPUT_FILE, ERROR_FILE, year);
            animeFilms.writeToFile(OUTPUT_FILE, filteredAnimes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fet");
    }

    public String readTextFile(String inputFile, String errorFile, int year) throws IOException {
        StringBuilder filteredAnimes = new StringBuilder();
        StringBuilder badFormatted = new StringBuilder();

        try (BufferedReader input = new BufferedReader(new FileReader(inputFile))) {

            String header = input.readLine();
            filteredAnimes.append(header).append("\n");

            String line;
            while ((line = input.readLine()) != null) {
                if (!line.matches("^.+;[0-9]{4};(10|[0-9]\\.[0-9]);[0-9]+;[A-Za-z/\\-]+$")) {
                    badFormatted.append(line).append("\n");
                    continue;
                }

                String[] rows = line.split(";");
                int animeYear = Integer.parseInt(rows[1]);

                if (animeYear == year) {
                    filteredAnimes.append(line).append("\n");
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if (!badFormatted.isEmpty()) {
            writeToFile(errorFile, badFormatted.toString());
        }

        return filteredAnimes.isEmpty() ? "" : filteredAnimes.toString();
    }

    public void writeToFile(String file, String text) throws IOException {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
            output.write(text);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}
