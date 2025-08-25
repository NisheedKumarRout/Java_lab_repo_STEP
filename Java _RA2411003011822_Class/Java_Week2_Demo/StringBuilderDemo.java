// StringBuilderDemo.java
public class StringBuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== STRINGBUILDER BASICS ===");

        // Empty StringBuilder
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());  // Default 16
        System.out.println("Initial length: " + sb.length());      // 0 characters

        // Building a string step by step
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        System.out.println("After appends: " + sb.toString());
        System.out.println("Current length: " + sb.length());
        System.out.println("Current capacity: " + sb.capacity());

        // === STRINGBUILDER METHODS ===
        System.out.println("\n=== STRINGBUILDER METHODS ===");
        StringBuilder demo = new StringBuilder("Java Programming");
        System.out.println("Original: " + demo);

        // Insert
        demo.insert(5, "Advanced ");
        System.out.println("After insert: " + demo);

        // Delete (remove 'Advanced ')
        demo.delete(5, 14);
        System.out.println("After delete: " + demo);

        // Replace
        demo.replace(5, 16, "Development");
        System.out.println("After replace: " + demo);

        // Reverse
        StringBuilder reverse = new StringBuilder("Hello");
        reverse.reverse();
        System.out.println("Reversed 'Hello': " + reverse);

        // Method chaining
        String result = new StringBuilder()
                .append("Java")
                .append(" is")
                .append(" awesome")
                .append("!")
                .toString();
        System.out.println("Method chaining result: " + result);

        // === STRINGBUFFER COMPARISON ===
        System.out.println("\n=== STRINGBUFFER COMPARISON ===");
        // StringBuffer is thread-safe (synchronized), unlike StringBuilder
        StringBuffer sbf = new StringBuffer("Thread-Safe");
        sbf.append(" String");
        System.out.println("StringBuffer result: " + sbf);

        // Demonstrating capacity growth
        StringBuilder growing = new StringBuilder(5); // Small initial capacity
        System.out.println("Custom initial capacity: " + growing.capacity());
        growing.append("This is a long string that exceeds initial capacity");
        System.out.println("After long append, new capacity: " + growing.capacity());
        System.out.println("Content: " + growing);
    }
}
