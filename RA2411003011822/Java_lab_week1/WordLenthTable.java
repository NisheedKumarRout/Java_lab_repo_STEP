import java.util.Scanner;

public class WordLengthTable {


    public static String[] splitIntoWords(String text) {
        String[] words = new String[100]; // assuming max 100 words
        int wordIndex = 0;
        String currentWord = "";

        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[wordIndex] = currentWord;
                    wordIndex++;
                    currentWord = "";
                }
            }
        }

        if (!currentWord.equals("")) {
            words[wordIndex] = currentWord;
            wordIndex++;
        }


        String[] result = new String[wordIndex];
        for (int i = 0; i < wordIndex; i++) {
            result[i] = words[i];
        }

        return result;
    }


    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }


    public static String[][] getWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int length = getLength(words[i]);
            result[i][1] = String.valueOf(length);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();


        String[] words = splitIntoWords(input);


        String[][] wordTable = getWordLengthTable(words);


        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");
        for (int i = 0; i < wordTable.length; i++) {
            String word = wordTable[i][0];
            int length = Integer.parseInt(wordTable[i][1]);
            System.out.println(word + "\t\t" + length);
        }

        scanner.close();
    }
}
