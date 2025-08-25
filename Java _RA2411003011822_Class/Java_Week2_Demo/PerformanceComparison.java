// Save this as PerformanceComparison.java
public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 5000; // Adjust iterations for testing
        String baseString = "Java";

        System.out.println("=== PERFORMANCE COMPARISON ===");
        System.out.println("Iterations: " + iterations);

        // Method 1: String concatenation (Poor Performance)
        long startTime = System.currentTimeMillis();
        String result1 = stringConcatenation(baseString, iterations);
        long stringTime = System.currentTimeMillis() - startTime;

        // Method 2: StringBuilder (Best Performance)
        startTime = System.currentTimeMillis();
        String result2 = stringBuilderMethod(baseString, iterations);
        long sbTime = System.currentTimeMillis() - startTime;

        // Method 3: StringBuffer (Good Performance, Thread-Safe)
        startTime = System.currentTimeMillis();
        String result3 = stringBufferMethod(baseString, iterations);
        long sbfTime = System.currentTimeMillis() - startTime;

        // Method 4: StringBuilder with initial capacity (Optimal)
        startTime = System.currentTimeMillis();
        String result4 = stringBuilderOptimized(baseString, iterations);
        long sbOptTime = System.currentTimeMillis() - startTime;

        // === RESULTS ===
        System.out.println("\n=== PERFORMANCE RESULTS ===");
        System.out.println("String concatenation:       " + stringTime + " ms");
        System.out.println("StringBuilder:              " + sbTime + " ms");
        System.out.println("StringBuffer:               " + sbfTime + " ms");
        System.out.println("StringBuilder (optimized):  " + sbOptTime + " ms");

        // === RATIOS ===
        System.out.println("\n=== PERFORMANCE RATIO ===");
        if (sbTime > 0) {
            System.out.println("StringBuilder is " + (stringTime / sbTime) + "x faster than String");
        }
        if (sbfTime > 0) {
            System.out.println("StringBuffer is " + (stringTime / sbfTime) + "x faster than String");
        }

        // === VERIFY ===
        boolean allEqual = result1.equals(result2) &&
                           result2.equals(result3) &&
                           result3.equals(result4);

        System.out.println("\nAll results equal: " + allEqual);
        System.out.println("Final length: " + result1.length());
    }

    // Method 1: Poor performance (creates new object every time)
    public static String stringConcatenation(String base, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += base;
        }
        return result;
    }

    // Method 2: Good performance (StringBuilder)
    public static String stringBuilderMethod(String base, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(base);
        }
        return sb.toString();
    }

    // Method 3: Thread-safe (StringBuffer)
    public static String stringBufferMethod(String base, int count) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append(base);
        }
        return sbf.toString();
    }

    // Method 4: Optimized StringBuilder (pre-allocated capacity)
    public static String stringBuilderOptimized(String base, int count) {
        StringBuilder sb = new StringBuilder(base.length() * count);
        for (int i = 0; i < count; i++) {
            sb.append(base);
        }
        return sb.toString();
    }
}
