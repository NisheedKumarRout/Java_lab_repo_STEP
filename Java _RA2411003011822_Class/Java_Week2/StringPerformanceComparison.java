public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // Test 1: String concatenation (slow method)
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // Test 2: StringBuilder (faster method, not thread-safe)
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        // Test 3: StringBuffer (fast and thread-safe)
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        // Demonstrating StringBuilder methods
        demonstrateStringBuilderMethods();

        // Demonstrating StringBuffer thread safety
        demonstrateThreadSafety();

        // Demonstrating different string comparison methods
        compareStringComparisonMethods();

        // Demonstrating memory efficiency
        demonstrateMemoryEfficiency();
    }

    // String concatenation using +
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }

    // Using StringBuilder
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // Using StringBuffer
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // Demonstrating StringBuilder methods
    public static void demonstrateStringBuilderMethods() {
        System.out.println("\n=== StringBuilder Methods ===");
        StringBuilder sb = new StringBuilder("Hello World");

        sb.append("!!!"); // add at end
        System.out.println("append: " + sb);

        sb.insert(6, "Java "); // insert at index
        System.out.println("insert: " + sb);

        sb.delete(6, 11); // delete characters
        System.out.println("delete: " + sb);

        sb.deleteCharAt(0); // delete char at index
        System.out.println("deleteCharAt: " + sb);

        sb.reverse(); // reverse string
        System.out.println("reverse: " + sb);

        sb.reverse(); // reverse back
        sb.replace(0, 5, "Hi"); // replace substring
        System.out.println("replace: " + sb);

        sb.setCharAt(0, 'h'); // change char
        System.out.println("setCharAt: " + sb);

        System.out.println("capacity: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("ensureCapacity(50): " + sb.capacity());
        sb.trimToSize();
        System.out.println("trimToSize: " + sb.capacity());
    }

    // Demonstrating thread safety
    public static void demonstrateThreadSafety() {
        System.out.println("\n=== Thread Safety Demo ===");
        StringBuffer buffer = new StringBuffer("Start");

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                buffer.append("X");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final StringBuffer content (thread-safe): " + buffer);
    }

    // Comparing string comparison methods
    public static void compareStringComparisonMethods() {
        System.out.println("\n=== String Comparison Methods ===");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== comparison (str1 == str2): " + (str1 == str2));
        System.out.println("== comparison (str1 == str3): " + (str1 == str3));
        System.out.println("equals(): " + str1.equals(str3));
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo(): " + str1.compareTo("World"));
        System.out.println("compareToIgnoreCase(): " + str1.compareToIgnoreCase("HELLO"));
    }

    // Demonstrating memory efficiency
    public static void demonstrateMemoryEfficiency() {
        System.out.println("\n=== Memory Efficiency ===");
        String s1 = "Java";
        String s2 = "Java"; // same reference from string pool
        String s3 = new String("Java"); // new object

        System.out.println("s1 == s2 (pool): " + (s1 == s2));
        System.out.println("s1 == s3 (different objects): " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial capacity: " + sb.capacity());
        sb.append(" This is a long text to increase capacity...");
        System.out.println("Increased capacity: " + sb.capacity());
    }
}
