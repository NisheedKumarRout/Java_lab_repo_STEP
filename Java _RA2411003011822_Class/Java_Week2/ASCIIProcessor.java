import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Character Analysis ---");

        // For each character in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;

            // 1. Display character and ASCII code
            System.out.println("Character: '" + ch + "'  ASCII: " + ascii);

            // 2. Determine type
            String type = classifyCharacter(ch);
            System.out.println("Type: " + type);

            // 3. If letter, show both upper and lower case with ASCII codes
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Uppercase: " + upper + " (ASCII: " + (int) upper + ")");
                System.out.println("Lowercase: " + lower + " (ASCII: " + (int) lower + ")");

                // 4. Difference between ASCII values
                System.out.println("Difference (Upper - Lower): " + ((int) upper - (int) lower));
            }
            System.out.println();
        }

        // Create ASCII table for a range
        System.out.println("\n--- ASCII Table (65 to 90) ---");
        displayASCIITable(65, 90); // A–Z

        // Convert string to ASCII array and back
        int[] asciiArray = stringToASCII(input);
        System.out.println("\nString to ASCII Array: " + Arrays.toString(asciiArray));
        String backToString = asciiToString(asciiArray);
        System.out.println("ASCII Array back to String: " + backToString);

        // Simple Caesar cipher
        System.out.println("\n--- Caesar Cipher (shift = 3) ---");
        String ciphered = caesarCipher(input, 3);
        System.out.println("Encrypted: " + ciphered);
        String deciphered = caesarCipher(ciphered, -3);
        System.out.println("Decrypted: " + deciphered);

        scanner.close();
    }

    // Method to classify character type
    public static String classifyCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return "Uppercase Letter";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Lowercase Letter";
        } else if (ch >= '0' && ch <= '9') {
            return "Digit";
        } else {
            return "Special Character";
        }
    }

    // Method to convert case using ASCII manipulation
    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32); // convert to lowercase
        } else if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32); // convert to uppercase
        } else {
            return ch; // unchanged
        }
    }

    // Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' + shift + 26) % 26 + 'A');
                result += c;
            } else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
                result += c;
            } else {
                result += ch; // keep digits and special chars same
            }
        }
        return result;
    }

    // Method to create ASCII table for a range
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    // Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    // Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        String result = "";
        for (int value : asciiValues) {
            result += (char) value;
        }
        return result;
    }
}
HI