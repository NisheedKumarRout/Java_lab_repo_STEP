import java.util.Scanner;

public class TextAnalyzer {


    public static String[] splitText(String text) {
        String[] words = new String[100];
        int wordCount = 0;
        String currentWord = "";

        for (int i = 0; i < getStringLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[wordCount++] = currentWord;
                    currentWord = "";
                }
            }
        }


        if (!currentWord.equals("")) {
            words[wordCount++] = currentWord;
        }


        String[] finalWords = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            finalWords[i] = words[i];
        }
        return finalWords;
    }


    public static int getStringLength(String str) {
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


    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }

        return result;
    }


    public static int[] findMinMaxIndex(String[][] wordLengthArray) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < wordLengthArray.length; i++) {
            int currentLength = Integer.parseInt(wordLengthArray[i][1]);
            int minLength = Integer.parseInt(wordLengthArray[minIndex][1]);
            int maxLength = Integer.parseInt(wordLengthArray[maxIndex][1]);

            if (currentLength < minLength) {
                minIndex = i;
            }
            if (currentLength > maxLength) {
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();


        String[] words = splitText(input);


        String[][] wordLengthArray = getWordLengthArray(words);


        int[] minMax = findMinMaxIndex(wordLengthArray);


        System.out.println("Shortest word: " + wordLengthArray[minMax[0]][0] + " (Length: " + wordLengthArray[minMax[0]][1] + ")");
        System.out.println("Longest word: " + wordLengthArray[minMax[1]][0] + " (Length: " + wordLengthArray[minMax[1]][1] + ")");
    }
}
