import java.util.*;

public class Problem6 {
    
    // Split text into words without using split()
    public static String[] splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (start < i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        return words.toArray(new String[0]);
    }
    
    // Justify text using StringBuilder
    public static List<String> justifyText(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (count + 1 + words[last].length() > width) break;
                count += 1 + words[last].length();
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;
            
            // If last line or line with one word - left justify
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(' ');
                }
                // Fill remaining spaces
                for (int i = sb.length(); i < width; i++) {
                    sb.append(' ');
                }
            } else {
                // Distribute spaces evenly
                int totalSpaces = width - count + gaps; // count already includes minimum spaces
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    for (int s = 0; s < spacePerGap; s++) sb.append(' ');
                    if (extraSpaces > 0) {
                        sb.append(' ');
                        extraSpaces--;
                    }
                }
                sb.append(words[last - 1]);
            }
            
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
    
    // Center align text
    public static List<String> centerAlign(List<String> lines, int width) {
        List<String> centered = new ArrayList<>();
        for (String line : lines) {
            int padding = (width - line.trim().length()) / 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < padding; i++) sb.append(' ');
            sb.append(line.trim());
            // Add remaining spaces if needed to make width equal
            while (sb.length() < width) sb.append(' ');
            centered.add(sb.toString());
        }
        return centered;
    }
    
    // Format using string concatenation (for performance comparison)
    public static List<String> justifyTextConcat(String[] words, int width) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (count + 1 + words[last].length() > width) break;
                count += 1 + words[last].length();
                last++;
            }
            
            String line = "";
            int gaps = last - index - 1;
            
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line += words[i];
                    if (i != last - 1) line += " ";
                }
                while (line.length() < width) line += " ";
            } else {
                int totalSpaces = width - count + gaps;
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int i = index; i < last - 1; i++) {
                    line += words[i] + " ";
                    for (int s = 0; s < spacePerGap; s++) line += " ";
                    if (extraSpaces > 0) {
                        line += " ";
                        extraSpaces--;
                    }
                }
                line += words[last - 1];
            }
            
            lines.add(line);
            index = last;
        }
        return lines;
    }
    
    // Display formatted text with line numbers and char counts
    public static void displayFormatted(List<String> lines, String title) {
        System.out.println("\n--- " + title + " ---");
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("%2d: %s (%d chars)\n", i + 1, lines.get(i), lines.get(i).length());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter text to format:");
        String text = sc.nextLine();
        
        System.out.print("Enter desired line width: ");
        int width = sc.nextInt();
        sc.nextLine(); // consume newline
        
        String[] words = splitWords(text);
        
        // Justify with StringBuilder
        long startTime = System.nanoTime();
        List<String> justified = justifyText(words, width);
        long endTime = System.nanoTime();
        long durationBuilder = endTime - startTime;
        
        // Justify with String concatenation
        startTime = System.nanoTime();
        List<String> justifiedConcat = justifyTextConcat(words, width);
        endTime = System.nanoTime();
        long durationConcat = endTime - startTime;
        
        // Center align based on justified text
        List<String> centered = centerAlign(justified, width);
        
        System.out.println("\nOriginal Text:\n" + text);
        displayFormatted(justified, "Left Justified Text");
        displayFormatted(centered, "Center Aligned Text");
        
        System.out.println("\nPerformance:");
        System.out.println("StringBuilder justify time: " + durationBuilder + " ns");
        System.out.println("String concatenation justify time: " + durationConcat + " ns");
    }
}
