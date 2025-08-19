import java.util.*;

public class Problem4 {
    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char)((c - base + shift + 26) % 26 + base));
            } else sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void displayAscii(String original, String encrypted) {
        System.out.println("Char\tASCII(original)\tASCII(encrypted)");
        for (int i = 0; i < original.length(); i++) {
            System.out.println(original.charAt(i) + "\t" + (int)original.charAt(i) + "\t\t" + (int)encrypted.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        displayAscii(text, encrypted);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("Valid decryption: " + text.equals(decrypted));
    }
}
