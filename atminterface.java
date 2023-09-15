import java.util.Scanner;
class User {
    private String name;
    private int pin;
    private double balance;
    public User(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public int getPin() {
        return pin;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class ATM {
    private User user;
    public ATM(User user) {
        this.user = user;
    }
    public void displayMenu() {
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }
    public void checkBalance() {
        System.out.println("Your balance is: " + user.getBalance());
    }
    public void withdraw() {
        System.out.println("Enter the amount you want to withdraw: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Your new balance is: " + user.getBalance());
        }
    }
    public void deposit() {
        System.out.println("Enter the amount you want to deposit: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        user.setBalance(user.getBalance() + amount);
        System.out.println("Your new balance is: " + user.getBalance());
    }
    public void transfer() {
        System.out.println("Enter the account number you want to transfer to: ");
        Scanner sc = new Scanner(System.in );
        String accountNumber = sc.nextLine();
        System.out.println("Enter the amount you want to transfer: ");
        double amount = sc.nextDouble();
        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            user.setBalance(user.getBalance() - amount);
            System.out.println("Your new balance is: " + user.getBalance());
            System.out.println("The amount has been transferred to account number: " + accountNumber);
        }
    }
    public void exit() {
        System.out.println("Thank you for using our ATM.");
    }
    public void run() {
        displayMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your pin: ");
        int pin = sc.nextInt();
        System.out.println("Enter your balance: ");
        double balance = sc.nextDouble();
        User user = new User(name, pin, balance);
        ATM atm = new ATM(user);
        atm.run();
    }
}