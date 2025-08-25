public class StringManipulation {
public static void main(String[] args) {
// 1. String literal
String str1 = "Java Programming";
// 2. Using new String()
String str2 = new String("Java Programming");
// 3. Using character array
char[] chars = {'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};
String str3 = new String(chars);
// Compare using == and equals()
System.out.println("str1 == str2: " + (str1 == str2));
System.out.println("str1.equals(str2): " + str1.equals(str2));
// Escape sequences
String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";
System.out.println(quote);
}
}