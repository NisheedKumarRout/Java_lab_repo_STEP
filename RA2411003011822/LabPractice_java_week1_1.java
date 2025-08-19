import java.util.Scanner;

public class StringLengthCalculator {


    public static int getLengthWithoutLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        int customLength = getLengthWithoutLength(input);
        int builtInLength = input.length();
        System.out.println("Length without using length() method: " + customLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        scanner.close();
    }
}
