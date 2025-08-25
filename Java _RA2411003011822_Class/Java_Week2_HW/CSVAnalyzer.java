import java.util.Scanner;

public class CSVAnalyzer {
    static String[][] parseCSV(String input) {
        String[] lines = input.split("\n");
        String[][] data = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            data[i] = lines[i].split(",");
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = data[i][j].trim();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data (end with blank line):");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            sb.append(line).append("\n");
        }
        String[][] data = parseCSV(sb.toString());
        System.out.println("Formatted Data:");
        for (String[] row : data) {
            for (String field : row) {
                System.out.print(field + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
