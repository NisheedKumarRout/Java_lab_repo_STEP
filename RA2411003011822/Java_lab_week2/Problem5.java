import java.util.*;

public class Problem5 {
    
    // Validate email format
    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');
        
        if (atIndex == -1 || atIndex != lastAtIndex) return false; // exactly one '@'
        
        if (atIndex == 0 || atIndex == email.length() - 1) return false; // username or domain empty
        
        String domain = email.substring(atIndex + 1);
        if (!domain.contains(".")) return false; // at least one '.' after '@'
        
        // Check domain name and extension not empty
        int dotIndex = domain.indexOf('.');
        if (dotIndex == 0 || dotIndex == domain.length() - 1) return false;
        
        return true;
    }
    
    // Extract email components
    public static String[] extractComponents(String email) {
        int atIndex = email.indexOf('@');
        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        
        int dotIndex = domain.indexOf('.');
        String domainName = domain.substring(0, dotIndex);
        String extension = domain.substring(dotIndex + 1);
        
        return new String[]{username, domain, domainName, extension};
    }
    
    // Analyze email statistics
    public static void analyzeEmails(List<String> emails, List<Boolean> valids, List<String[]> components) {
        int validCount = 0;
        Map<String, Integer> domainCount = new HashMap<>();
        int totalUsernameLength = 0;
        
        for (int i = 0; i < emails.size(); i++) {
            if (valids.get(i)) {
                validCount++;
                String domainName = components.get(i)[1]; // full domain
                domainCount.put(domainName, domainCount.getOrDefault(domainName, 0) + 1);
                totalUsernameLength += components.get(i)[0].length();
            }
        }
        
        int invalidCount = emails.size() - validCount;
        
        // Find most common domain
        String mostCommonDomain = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }
        
        double avgUsernameLength = validCount > 0 ? (double) totalUsernameLength / validCount : 0;
        
        System.out.println("\n--- Email Statistics ---");
        System.out.println("Total valid emails: " + validCount);
        System.out.println("Total invalid emails: " + invalidCount);
        System.out.println("Most common domain: " + (mostCommonDomain == null ? "N/A" : mostCommonDomain));
        System.out.printf("Average username length: %.2f\n", avgUsernameLength);
    }
    
    // Display results in tabular format
    public static void displayResults(List<String> emails, List<Boolean> valids, List<String[]> components) {
        System.out.println("\nEmail\t\tUsername\tDomain\t\tDomain Name\tExtension\tValid/Invalid");
        System.out.println("------------------------------------------------------------------------------------");
        for (int i = 0; i < emails.size(); i++) {
            String validStr = valids.get(i) ? "Valid" : "Invalid";
            if (valids.get(i)) {
                String[] comp = components.get(i);
                System.out.printf("%-16s %-12s %-16s %-12s %-10s %s\n", 
                                  emails.get(i), comp[0], comp[1], comp[2], comp[3], validStr);
            } else {
                System.out.printf("%-16s %-12s %-16s %-12s %-10s %s\n", 
                                  emails.get(i), "-", "-", "-", "-", validStr);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of emails: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        
        List<String> emails = new ArrayList<>();
        List<Boolean> valids = new ArrayList<>();
        List<String[]> components = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter email #" + (i+1) + ": ");
            String email = sc.nextLine();
            emails.add(email);
            
            boolean valid = isValidEmail(email);
            valids.add(valid);
            
            if (valid) {
                components.add(extractComponents(email));
            } else {
                components.add(new String[]{"-", "-", "-", "-"});
            }
        }
        
        displayResults(emails, valids, components);
        analyzeEmails(emails, valids, components);
    }
}
