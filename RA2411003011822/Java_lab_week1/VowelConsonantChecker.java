import java.util.Scanner;

public class VowelConsonantChecker {


    public static String checkCharType(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }


        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    public static String[][] findCharTypes(String input) {
        int len = input.length();
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }

        return result;
    }


    public static void displayResult(String[][] arr) {
        System.out.printf("%-10s | %-12s%n", "Character", "Type");
        System.out.println("--------------------------");
        for (String[] row : arr) {
            System.out.printf("%-10s | %-12s%n", row[0], row[1]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] charTypes = findCharTypes(input);

        displayResult(charTypes);

        sc.close();
    }
}
