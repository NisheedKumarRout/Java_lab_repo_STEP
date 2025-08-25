import java.util.Scanner;

public class SpellChecker {
    // Method to split sentence into words without split()
    static String[] splitSentence(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') count++;
        }
        String[] words = new String[count + 1];
        int start = 0, index = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                words[index++] = sentence.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = sentence.substring(start);
        return words;
    }

    // Method to calculate distance between two words
    static int stringDistance(String a, String b) {
        int diff = Math.abs(a.length() - b.length());
        int minLen = Math.min(a.length(), b.length());
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    // Find closest word from dictionary
    static String suggestWord(String word, String[] dict) {
        String suggestion = word;
        int minDist = Integer.MAX_VALUE;
        for (String d : dict) {
            int dist = stringDistance(word, d);
            if (dist < minDist) {
                minDist = dist;
                suggestion = d;
            }
        }
        if (minDist <= 2) return suggestion;
        return "No suggestion";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"java", "hello", "world", "programming", "code"};
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        String[] words = splitSentence(sentence);
        System.out.println("Word\tSuggestion\tDistance");
        for (String w : words) {
            String suggestion = suggestWord(w.toLowerCase(), dictionary);
            int dist = stringDistance(w.toLowerCase(), suggestion.toLowerCase());
            if (suggestion.equals("No suggestion"))
                System.out.println(w + "\tCorrect\t\t0");
            else
                System.out.println(w + "\t" + suggestion + "\t\t" + dist);
        }
        sc.close();
    }
}
