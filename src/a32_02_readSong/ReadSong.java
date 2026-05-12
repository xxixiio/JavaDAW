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

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            StringBuilder numberedText = new StringBuilder();

            String line;
            int lineCount = 1;
            while ((line = input.readLine()) != null) {
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
