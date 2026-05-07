package a25_01_spamDetector;

import java.util.*;

public class SpamDetector {
    public static void main(String[] args) {
        Set<String> forbiddenWords = new HashSet<>(Set.of(
                "spoof", "limited offer", "bot", "scam",
                "virus", "hoax", "keygen", "hack", "crack",
                "earn money", "easy money", "clickbait", "win lottery",
                "win money", "urgent", "win prize", "fraudulent", "phishing",
                "bots", "malware", "nsfw", "trojan", "pirated",
                "fraud", "scammer", "scamming", "xxx", "fake",
                "free money", "make money", "spam", "adult", "click here",
                "ransomware", "get rich"
        ));

        String text = """
                Congratulations! You can make money easily and earn money now.
                Win prize or win money instantly with this fake clickbait offer.
                Phishing attempts, trojan viruses, ransomware, and scam messages everywhere.
                Free money waiting for you! Click here to get rich.
                Fraudulent activities and spoof messages detected by our bot system.
                Scam, scam, scam! Win money, win money, free money, free money!
                Bots, bots, bots spreading clickbait and adult content. XXX content included.
                Malware, malware, trojan, trojan, phishing, phishing attempts everywhere.
                Limited offer! Limited offer! Get rich, get rich, earn money now!""";

        System.out.println(
                countForbiddenWords(text, forbiddenWords)
        );
    }

    /**
     * Receives a text and a set of forbidden words
     * and returns a Map with the number of occurrences of each word.
     */
    public static Map<String, Integer> countForbiddenWords(String text, Set<String> forbiddenWords) {
        text = text.toLowerCase().trim();
        ArrayList<String> splitedText = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        String w = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                w += c;
            } else {
                if (w.isBlank()) continue;
                splitedText.add(w);
                w = "";
            }
        }

        //System.out.println(splitedText);

        for (String t : splitedText) {
            for (String word : forbiddenWords) {
                    if (t.equals(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                }
            }
        }

        return count;
    }
}
