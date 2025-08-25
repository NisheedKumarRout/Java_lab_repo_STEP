import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String a = sc.nextLine();
        System.out.print("Enter second word: ");
        String b = sc.nextLine();
        char[] arr1 = a.replaceAll("\\s","").toLowerCase().toCharArray();
        char[] arr2 = b.replaceAll("\\s","").toLowerCase().toCharArray();
        Arrays.sort(arr1); Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }
}
