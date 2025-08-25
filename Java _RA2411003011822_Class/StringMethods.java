import java.util.Scanner; 
public class StringMethods { 
 public static void main(String[] args) { 
 Scanner scanner = new Scanner(System.in); 
  
 System.out.print("Enter your full name: "); 
 String fullName = scanner.nextLine(); 
  
 System.out.print("Enter your favorite programming language: "); 
 String language = scanner.nextLine(); 
  
 System.out.print("Write a sentence about your programming experience: ");  String sentence = scanner.nextLine(); 
  
 // Process 
 String[] nameParts = fullName.split(" "); 
 String firstName = nameParts[0]; 
 String lastName = nameParts[1]; 
  
 int charCount = sentence.replace(" ", "").length(); 
 String langUpper = language.toUpperCase(); 
  
 System.out.println("=== SUMMARY ==="); 
 System.out.println("First Name: " + firstName); 
 System.out.println("Last Name: " + lastName); 
 System.out.println("Character count (no spaces): " + charCount); 
 System.out.println("Language in uppercase: " + langUpper); 
  
 scanner.close(); 
 } 
} 
