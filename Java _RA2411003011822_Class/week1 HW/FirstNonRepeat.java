import java.util.Scanner;

public class FirstNonRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (text.indexOf(c) == text.lastIndexOf(c)) {
                System.out.println("First non-repeating: " + c);
                return;
            }
        }
        System.out.println("No non-repeating character.");
    }
}

