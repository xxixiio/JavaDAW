package a20_01_blockWordsManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class BlockWordsManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlockWordsManager blockWordsManager = new BlockWordsManager();
        HashSet<String> words = new HashSet<>(Arrays.asList(
                "spam", "scam", "fake", "clickbait", "hack", "virus",
                "phishing", "malware", "trojan", "ransomware",
                "fraud", "fraudulent", "hoax", "spoof",
                "bot", "bots", "scammer", "scamming",
                "free money", "get rich", "lottery", "prize",
                "win now", "urgent", "limited offer",
                "adult", "xxx", "nsfw",
                "crack", "pirated", "keygen"
        ));

        int option = blockWordsManager.menuPrompt(sc);

        while (option != 0) {
            if (option == 1) {
                System.out.println(words);
            } else if (option == 2) {
                System.out.println("Enter word to add:");
                String word = sc.nextLine();

                System.out.println(
                        blockWordsManager.addWord(words, word)
                                ? "Word added"
                                : "Word already exists"
                );
            } else if (option == 3) {
                System.out.println("Enter word to check:");
                String word = sc.nextLine();

                System.out.println(
                        blockWordsManager.containsWord(words, word)
                                ? "Word exists"
                                : "Word does not exist"
                );
            } else if (option == 4) {
                System.out.println("Enter word to remove:");
                String word = sc.nextLine();

                System.out.println(
                        blockWordsManager.removeWord(words, word)
                                ? "Word removed"
                                : "Word does not exist"
                );
            }

            option = blockWordsManager.menuPrompt(sc);
        }
    }

    public int menuPrompt(Scanner sc) {
        System.out.println("1. List words");
        System.out.println("2. Add a new word");
        System.out.println("3. Check if a word exists");
        System.out.println("4. Remove word");
        System.out.println("0. Exit");
        System.out.println("Choose option:");

        int option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    public boolean addWord(Set<String> words, String word) {
        return words.add(word.toLowerCase());
    }

    public boolean containsWord(Set<String> words, String word) {
        return words.contains(word.toLowerCase());
    }

    public boolean removeWord(Set<String> words, String word) {
        return words.remove(word.toLowerCase());
    }
}
