// src/ATMWithdrawal.java
import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawal {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin != PIN) {
                throw new InvalidPINException("Invalid PIN entered.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal Successful. Remaining Balance: " + balance);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
