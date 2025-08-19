import java.util.Scanner;

public class TextSplitter {


    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }


    public static String[] customSplit(String text) {
        int len = getLength(text);
        int wordCount = 0;


        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordStart = -1;
        int index = 0;

        for (int i = 0; i <= len; i++) {
            if (i < len && text.charAt(i) != ' ') {
                if (wordStart == -1) {
                    wordStart = i;
                }
            } else {
                if (wordStart != -1) {
                    words[index++] = extractWord(text, wordStart, i);
                    wordStart = -1;
                }
            }
        }

        return words;
    }


    public static String extractWord(String text, int start, int end) {
        String word = "";
        for (int i = start; i < end; i++) {
            word += text.charAt(i);
        }
        return word;
    }


    public static boolean compareArrays(String[] a1, String[] a2) {
        if (a1.length != a2.length) return false;

        for (int i = 0; i < a1.length; i++) {
            if (!a1[i].equals(a2[i])) {
                return false;
            }
        }
        return true;
    }


    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        String[] customWords = customSplit(input);
        String[] builtInWords = input.trim().split("\\s+");

        System.out.println("\nCustom split result:");
        printArray(customWords);

        System.out.println("\nBuilt-in split result:");
        printArray(builtInWords);

        boolean areEqual = compareArrays(customWords, builtInWords);
        System.out.println("\nDo both methods give the same result? " + areEqual);
    }
}
