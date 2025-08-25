// StringMethodsDemo.java
public class StringMethods {
    public static void main(String[] args) {
        String text = " Welcome to Java Programming World! ";

        // === INSPECTION METHODS ===
        System.out.println("=== INSPECTION METHODS ===");
        System.out.println("Original String: '" + text + "'");
        System.out.println("Length of string: " + text.length());
        System.out.println("Character at index 5: " + text.charAt(5));
        System.out.println("First occurrence of 'a': " + text.indexOf('a'));
        System.out.println("Last occurrence of 'a': " + text.lastIndexOf('a'));
        System.out.println("Does it contain 'Java'? " + text.contains("Java"));

        // === EXTRACTION METHODS ===
        System.out.println("\n=== EXTRACTION METHODS ===");
        System.out.println("Substring(0,7): '" + text.substring(0, 7) + "'");
        System.out.println("Substring from index 15: '" + text.substring(15) + "'");

        // Splitting words
        String[] words = text.trim().split(" ");
        System.out.println("After splitting, we got " + words.length + " words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("  Word " + (i + 1) + ": " + words[i]);
        }

        // === MODIFICATION METHODS ===
        System.out.println("\n=== MODIFICATION METHODS ===");
        System.out.println("Trimmed string: '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Replace 'Java' with 'Python': " + text.replace("Java", "Python"));
        System.out.println("Replace first 'a' with '@': " + text.replaceFirst("a", "@"));

        // === COMPARISON METHODS ===
        System.out.println("\n=== COMPARISON METHODS ===");
        String other = "welcome to programming world!";
        System.out.println("Equals (case-sensitive): " + text.trim().equals(other));
        System.out.println("Equals (ignore case): " + text.trim().equalsIgnoreCase(other));
        System.out.println("Starts with ' Welcome'? " + text.startsWith(" Welcome"));
        System.out.println("Ends with 'World! '? " + text.endsWith("World! "));
    }
}
