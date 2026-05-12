package a32_02_readSong;

import java.io.*;

public class ReadSong {
    public static void main(String[] args) {
        final String FILE_PATH = "src/a32_02_readSong/song.txt";
        ReadSong readSong = new ReadSong();

        try {
            System.out.println(readSong.readTextFile(FILE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readTextFile(String file) throws IOException {
        File fileObject = new File(file);
        if (!fileObject.exists()) throw new FileNotFoundException("File not found");
        //if (!fileObject.canExecute()) throw new IOException("Error reading file");

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            StringBuilder numberedText = new StringBuilder();

            int lineCount = 1;
            while (true) {
                String line = input.readLine();
                if (line == null) break;

                line = line.trim();
                numberedText.append(String.format("%d: %s%n", lineCount, line));
                lineCount += 1;
            }

            input.close();
            return numberedText.toString();
        } catch (IOException e) {
            throw new IOException("Error reading file");
        }
    }
}
