import java.util.Scanner;

public class StringCalculator {
    static int evaluate(String expr) {
        String[] tokens = expr.split(" ");
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String op = tokens[i];
            int num = Integer.parseInt(tokens[i + 1]);
            if (op.equals("+")) result += num;
            else if (op.equals("-")) result -= num;
            else if (op.equals("*")) result *= num;
            else if (op.equals("/")) result /= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression (use spaces, e.g., 10 + 5 * 2):");
        String expr = sc.nextLine();
        int result = evaluate(expr);
        System.out.println("Result: " + result);
        sc.close();
    }
}
