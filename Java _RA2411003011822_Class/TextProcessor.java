import java.util.*; 
public class TextProcessor { 
 public static String cleanInput(String input) { 
 input = input.trim().replaceAll(" +", " "); 
 return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();  } 
  
 public static void analyzeText(String text) { 
 String[] words = text.split("\s+"); 
 int wordCount = words.length; 
 int charCount = text.replace(" ", "").length(); 
 int sentenceCount = text.split("[.!?]").length; 
  
 String longestWord = ""; 
 for (String w : words) { 
 if (w.length() > longestWord.length()) longestWord = w; 
 } 
  
 Map<Character, Integer> freq = new HashMap<>(); 
 for (char c : text.replace(" ", "").toCharArray()) { 
 freq.put(c, freq.getOrDefault(c, 0) + 1); 
 } 
 char mostCommon = ' '; 
 int max = 0; 
 for (Map.Entry<Character, Integer> e : freq.entrySet()) { 
 if (e.getValue() > max) { 
 mostCommon = e.getKey(); 
 max = e.getValue(); 
 } 
 } 
  
 System.out.println("Words: " + wordCount); 
 System.out.println("Characters: " + charCount);
 System.out.println("Sentences: " + sentenceCount);  System.out.println("Longest Word: " + longestWord);  System.out.println("Most Common Char: " + mostCommon);  } 
  
 public static String[] getWordsSorted(String text) { 
 String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\s+");  Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);  return words; 
 } 
  
 public static void main(String[] args) { 
 Scanner scanner = new Scanner(System.in); 
 System.out.println("=== TEXT PROCESSOR ==="); 
 System.out.print("Enter a paragraph: "); 
 String paragraph = scanner.nextLine(); 
  
 paragraph = cleanInput(paragraph); 
 analyzeText(paragraph); 
  
 String[] sortedWords = getWordsSorted(paragraph);  System.out.println("Sorted Words: " + Arrays.toString(sortedWords));   
 System.out.print("Search for a word: "); 
 String search = scanner.nextLine(); 
 boolean found = Arrays.asList(sortedWords).contains(search);  System.out.println(found ? "Word found!" : "Word not found.");   
 scanner.close(); 
 } 
}
