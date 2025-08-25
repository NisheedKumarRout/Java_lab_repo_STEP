import java.util.Scanner;

public class TextCompressor {
    static void frequencyCount(String text, char[] chars, int[] freq) {
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (chars[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                chars[index] = c;
                freq[index] = 1;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        frequencyCount(text, chars, freq);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] > 0) {
                System.out.println(chars[i] + " : " + freq[i]);
            }
        }
        sc.close();
    }
}
