import java.util.Scanner;
// Represents a simple bank account
class BankAccount {
    private double balance;

    // Initializes account with a starting balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }

    // Handles deposits
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("CASH DISENSED SUCCESSFULLY !. AVAILABLE BALANCE: ₹" + balance);
        } else if (amount > balance) {
            System.out.println("INADEQUATE BALANCE.");
        } else {
            System.out.println("PLEASE ENTER A VALID AMOUNT.");
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Displays the ATM menu and handles user input
    public void displayMenu() {
        while (true) {
            System.out.println("\n ATM SERVICE ");
            System.out.println("1. VIEW BALANCE");
            System.out.println("2. ADD FUNDS ");
            System.out.println("3. WITHDRAW MONEY");
            System.out.println("4. LOG OUT");
            System.out.print("WHAT DO YOU WANT TO SELECT : ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input.\n Please enter a  valid number between 1 and 4.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("ENTER AMOUNT TO BE DEPOSITED: ");
                    double deposit = scanner.nextDouble();
                    userAccount.deposit(deposit);
                    break;
                case 3:
                    System.out.print("ENTER AMOUNT YOU WANT TO WITHDRAW: ");
                    double withdraw = scanner.nextDouble();
                    userAccount.withdraw(withdraw);
                    break;
                case 4:
                    System.out.println(" EXITING.\n THANK YOU FOR CHOOSING OUR ATM SERVICES.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. \nPlease choose valid option between 1 and 4.");
            }
        }
    }
}

public class ATMINTERFACE {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}