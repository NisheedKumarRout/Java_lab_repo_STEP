import java.util.*;

public class PasswordAnalyzer {
    // Analyze strength
    static int analyzePassword(String pass) {
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (ch >= 65 && ch <= 90) upper++;
            else if (ch >= 97 && ch <= 122) lower++;
            else if (ch >= 48 && ch <= 57) digit++;
            else special++;
        }
        int score = 0;
        score += (pass.length() - 8) * 2;
        if (upper > 0) score += 10;
        if (lower > 0) score += 10;
        if (digit > 0) score += 10;
        if (special > 0) score += 10;
        if (pass.contains("123") || pass.contains("abc") || pass.contains("qwerty")) score -= 10;
        return score;
    }

    static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    // Generate strong password
    static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()";
        String all = upper + lower + digits + special;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(r.nextInt(upper.length())));
        sb.append(lower.charAt(r.nextInt(lower.length())));
        sb.append(digits.charAt(r.nextInt(digits.length())));
        sb.append(special.charAt(r.nextInt(special.length())));
        while (sb.length() < length) {
            sb.append(all.charAt(r.nextInt(all.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        int score = analyzePassword(pass);
        System.out.println("Password: " + pass);
        System.out.println("Score: " + score);
        System.out.println("Strength: " + strengthLevel(score));
        System.out.println("Generated Strong Password: " + generatePassword(12));
        sc.close();
    }
}
