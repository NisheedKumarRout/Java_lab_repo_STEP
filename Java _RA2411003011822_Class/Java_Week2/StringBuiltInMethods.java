public class StringBuiltinMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Display original string length including spaces
        System.out.println("Original String: '" + sampleText + "'");
        System.out.println("Original Length (with spaces): " + sampleText.length());

        // 2. Remove leading and trailing spaces, show new length
        String trimmed = sampleText.trim();
        System.out.println("Trimmed String: '" + trimmed + "'");
        System.out.println("Length after trim: " + trimmed.length());

        // 3. Find and display the character at index 5
        char ch = sampleText.charAt(5);
        System.out.println("Character at index 5: " + ch);

        // 4. Extract substring "Programming" from the text
        String sub = trimmed.substring(5, 16); // "Programming"
        System.out.println("Extracted Substring: " + sub);

        // --- Extra Tasks ---
        // Count vowels
        int vowelCount = countVowels(trimmed);
        System.out.println("Total Vowels: " + vowelCount);

        // Find all occurrences of a character (e.g., 'a')
        System.out.println("Occurrences of 'a':");
        findAllOccurrences(trimmed, 'a');
    }

    // Method to count vowels in a string
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.println("Character '" + target + "' found at index: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Character '" + target + "' not found.");
            System.out.println
        }
    }
}