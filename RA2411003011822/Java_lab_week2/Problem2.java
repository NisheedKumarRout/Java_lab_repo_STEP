import java.util.*;

public class Problem2 {
    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
    }

    public static char toLower(char c) {
        return (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }

    public static String toTitleCase(String str) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                capitalize = true;
            } else {
                sb.append(capitalize ? toUpper(c) : toLower(c));
                capitalize = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upper = toUpperCase(text);
        String lower = toLowerCase(text);
        String title = toTitleCase(text);

        System.out.println("Custom\t\tBuilt-in");
        System.out.println("Upper: " + upper + "\t" + text.toUpperCase());
        System.out.println("Lower: " + lower + "\t" + text.toLowerCase());
        System.out.println("Title: " + title);
    }
}
