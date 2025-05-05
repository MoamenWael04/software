import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to InvestEase!");
        System.out.println("------------------------");
        System.out.println(" select 1 to login ");
        System.out.println(" select 2 to signup ");
        System.out.println("------------------------");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        choice = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        if (choice == 1) {
            System.out.print("Enter User ID: ");
            String userID = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (Authentcation.checkpassword(userID, password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid credentials. Login failed.");
            }
        }
        else if (choice == 2) {
            System.out.print("Enter User ID: ");
            String userID = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter User Name: ");
            String userName = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            // Should be using Authentcation.createUser instead of User.signup
            User user = User.signup(userID, password, userName, email);
            if (user != null) {
                System.out.println("Signup successful!");
            } else {
                System.out.println("Signup failed.");
            }
        }

        scanner.close();
    }
}