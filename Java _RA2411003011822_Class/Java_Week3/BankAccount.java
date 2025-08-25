public class BankAccount {
    // 🔹 Static variables (shared by ALL accounts, only one copy in memory)
    static String bankName;
    static int totalAccounts = 0;
    static double interestRate;

    // 🔹 Instance variables (each account has its own copy)
    String accountNumber;
    String accountHolder;
    double balance;

    // 🔹 Constructor: initializes instance variables and increments static counter
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // Every new account increases total count
    }

    // 🔹 Static methods (operate on static data, not tied to any one account)
    static void setBankName(String name) {
        bankName = name;
    }

    static void setInterestRate(double rate) {
        interestRate = rate;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println();
    }

    // 🔹 Instance methods (operate on individual account data)
    void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println(accountHolder + " tried to withdraw " + amount + " but has insufficient balance.");
        }
    }

    void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println(accountHolder + " earned interest: " + interest);
    }

    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    // 🔹 Main method - where program runs
    public static void main(String[] args) {
        // ✅ Set static variables (same for all accounts)
        BankAccount.setBankName("OpenAI National Bank");
        BankAccount.setInterestRate(5.0);

        // ✅ Create multiple accounts (each with unique data)
        BankAccount acc1 = new BankAccount("1001", "Alice", 5000);
        BankAccount acc2 = new BankAccount("1002", "Bob", 3000);
        BankAccount acc3 = new BankAccount("1003", "Charlie", 7000);

        // ✅ Display bank info (static data is shared)
        BankAccount.displayBankInfo();

        // ✅ Show individual account info
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();

        // ✅ Perform some operations
        acc1.deposit(1000);
        acc2.withdraw(500);
        acc3.calculateInterest();

        // ✅ Show total accounts using static method
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());

        // ✅ Demonstrate calling static method with object (not recommended, but allowed)
        acc1.displayBankInfo(); // works, but better to call as BankAccount.displayBankInfo()

        /*
         📝 Real-world analogy:
         - Static members = properties shared by the whole bank (bank name, interest rate, total accounts).
         - Instance members = unique details of each account (account number, holder name, balance).
         - Even if 1000 accounts exist, there’s only ONE copy of static variables.
         - But each account has its own balance and account number.
        */
    }
}
