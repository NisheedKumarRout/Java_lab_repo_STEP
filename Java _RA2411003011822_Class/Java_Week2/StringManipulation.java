import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();

        // 1. trim() - Remove extra spaces
        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        // 2. replace() - Replace all spaces with underscores
        String replacedSpaces = trimmed.replace(" ", "_");
        System.out.println("Spaces replaced with underscores: " + replacedSpaces);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = trimmed.replaceAll("[0-9]", "");
        System.out.println("Without digits: " + noDigits);

        // 4. split() - Split sentence into words array
        String[] words = trimmed.split("\\s+");
        System.out.println("Words array: " + Arrays.toString(words));

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("Rejoined with | : " + joined);

        // --- Extra Processing ---
        System.out.println("\n--- Extra Processing ---");

        // Remove punctuation
        String noPunct = removePunctuation(trimmed);
        System.out.println("Without punctuation: " + noPunct);

        // Capitalize first letter of each word
        String capitalized = capitalizeWords(noPunct);
        System.out.println("Capitalized Words: " + capitalized);

        // Reverse word order
        String reversed = reverseWordOrder(noPunct);
        System.out.println("Reversed Word Order: " + reversed);

        // Count word frequency
        System.out.println("Word Frequency:");
        countWordFrequency(noPunct);

        scanner.close();
    }

    // Method to remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    // Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        String result = "";
        for (String word : words) {
            if (!word.isEmpty()) {
                result += Character.toUpperCase(word.charAt(0)) 
                          + word.substring(1).toLowerCase() + " ";
            }
        }
        return result.trim();
    }

    // Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i] + " ";
        }
        return result.trim();
    }

    // Method to count word frequency (without Map, using array)
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        boolean[] counted = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        counted[j] = true; // mark as counted
                    }
                }
                System.out.println(words[i] + " → " + count);
            }
        }
    }
}
