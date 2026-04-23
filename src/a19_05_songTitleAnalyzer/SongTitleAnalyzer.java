package a19_05_songTitleAnalyzer;

import java.util.*;

public class SongTitleAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SongTitleAnalyzer songTitleAnalyzer = new SongTitleAnalyzer();

        List<String> list = getStringList();

        System.out.println("1. Show title lengths");
        System.out.println("2. Find positions containing text");
        System.out.println("3. Filter titles containing text");
        System.out.println("4. Show titles sorted alphabetically");
        System.out.println("0. Exit");
        System.out.println("Choose option?");

        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.println(songTitleAnalyzer.getLengths(list));
        } else if (option == 2) {
            System.out.println("Enter text:");
            String text = sc.nextLine();

            System.out.println(songTitleAnalyzer.findPositionsContaining(list, text));
        } else if (option == 3) {
            System.out.println("Enter text:");
            String text = sc.nextLine();

            System.out.println(songTitleAnalyzer.filterContaining(list, text));
        } else {
            System.out.println(songTitleAnalyzer.sortAlphabetically(list));
        }
    }

    private static List<String> getStringList() {
        String[] values = {
                "Midnight Signals",
                "Echoes of You",
                "Fire in My Veins",
                "Dancing Through Silence",
                "Broken Neon Lights",
                "Forever Starts Tonight",
                "Whispers in the Dark",
                "Golden Hour Dreams",
                "Runaway Hearts",
                "Last Summer Again",
                "Shadows on Repeat",
                "Neon Skies Forever",
                "Heartbeat in Stereo",
                "Falling Without Gravity",
                "After the Last Goodbye",
                "City Lights on Fire",
                "Lost Between the Lines",
                "Dreaming in Slow Motion",
                "When the Night Breaks",
                "Echoes of a New Day"
        };

        return new ArrayList<>(Arrays.asList(values));
    }

    public List<Integer> getLengths(List<String> list) {
        List<Integer> listLengths = new ArrayList<>();
        list.forEach(e -> listLengths.add(e.length()));
        return listLengths;
    }

    public List<Integer> findPositionsContaining(List<String> list, String text) {
        List<Integer> foundPositions = new ArrayList<>();
        text = text.trim().toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            s = s.trim().toLowerCase();
            if (s.contains(text))
                foundPositions.add(i);
        }

        return foundPositions;
    }

    public List<String> filterContaining(List<String> list, String text) {
        List<Integer> foundPositions = findPositionsContaining(list, text);
        List<String> filteredList = new ArrayList<>();
        for (int i : foundPositions) {
            filteredList.add(list.get(i));
        }

        return filteredList;
    }

    public List<String> sortAlphabetically(List<String> list) {
        List<String> orderedList = list;
        orderedList.sort(String.CASE_INSENSITIVE_ORDER);

        return orderedList;
    }
}
