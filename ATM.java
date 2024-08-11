import java.util.Scanner;

// user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
            return true;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        } else {
            System.out.println("Insufficient funds for withdrawal");
            return false;
        }
    }
    public double getBalance() {
        return balance;
    }

}

// Class for the ATM machine
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // ATM interface
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Initialize bank account with an initial balance
        BankAccount myAccount = new BankAccount(1000);
        ATM atmMachine = new ATM(myAccount);
        // Display method
        atmMachine.showMenu();
    }
}
