package a20_03_sortJavaKeywords;

import java.util.*;

public class SortJavaKeywords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortJavaKeywords sortJavaKeywords = new SortJavaKeywords();

        Set<String> words = new HashSet<>(Arrays.asList(
                "abstract", "assert", "boolean", "break",
                "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do",
                "double", "else", "enum", "extends",
                "final", "finally", "float", "for",
                "if", "implements", "import",
                "instanceof", "int", "interface", "long",
                "new", "package", "private",
                "protected", "public", "return", "short",
                "static", "super", "switch",
                "synchronized", "this", "throw", "throws",
                "try", "void", "while"
        ));

        int option = sortJavaKeywords.promptMenu(sc);
        while (option != 0) {
            if (option == 1) {
                System.out.println(words);
            } else if (option == 2) {
                System.out.println(
                        sortJavaKeywords.listSortedAsc(words)
                );
            } else if (option == 3) {
                System.out.println(
                        sortJavaKeywords.listSortedDesc(words)
                );
            } else if (option == 4) {
                System.out.println(
                        sortJavaKeywords.setSortedAsc(words)
                );
            } else if (option == 5) {{
                System.out.println(
                        sortJavaKeywords.setSortedDesc(words)
                );
            }}

            option = sortJavaKeywords.promptMenu(sc);
        }
    }

    public int promptMenu(Scanner sc) {
        System.out.println("""
                1. Show keywords
                2. Show sorted list asc
                3. Show sorted list desc
                4. Show sorted set asc
                5. Show sorted set desc
                0. Exit
                Choose option:""");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public List<String> listSortedAsc(Set<String> words) {
        List<String> sortedList = new ArrayList<>(words);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<String> listSortedDesc(Set<String> words) {
        List<String> sortedList = new ArrayList<>(words);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public Set<String> setSortedAsc(Set<String> words) {
        return new TreeSet<>(words);
    }

    public Set<String> setSortedDesc(Set<String> words) {
        ArrayList<String> sortedList = new ArrayList<>(words);
        sortedList.sort(Collections.reverseOrder());
        return new LinkedHashSet<>(sortedList);
    }
}
