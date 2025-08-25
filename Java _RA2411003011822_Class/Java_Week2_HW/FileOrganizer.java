import java.util.*;

public class FileOrganizer {
    static String getExtension(String filename) {
        int dot = filename.lastIndexOf(".");
        if (dot == -1) return "";
        return filename.substring(dot + 1);
    }

    static String categorize(String ext) {
        if (ext.equals("txt") || ext.equals("doc")) return "Document";
        if (ext.equals("jpg") || ext.equals("png")) return "Image";
        if (ext.equals("mp3")) return "Audio";
        return "Unknown";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter filenames separated by space:");
        String[] files = sc.nextLine().split(" ");
        for (String f : files) {
            String ext = getExtension(f);
            String cat = categorize(ext);
            System.out.println(f + " -> " + cat);
        }
        sc.close();
    }
}
