import java.util.*;

public class Problem3 {
    public static long stringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) s += "a";
        return System.currentTimeMillis() - start;
    }

    public static long stringBuilderConcat(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }

    public static long stringBufferConcat(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter iterations: ");
        int n = sc.nextInt();

        long t1 = stringConcat(n);
        long t2 = stringBuilderConcat(n);
        long t3 = stringBufferConcat(n);

        System.out.println("Method\t\tTime(ms)");
        System.out.println("String\t\t" + t1);
        System.out.println("StringBuilder\t" + t2);
        System.out.println("StringBuffer\t" + t3);
    }
}
