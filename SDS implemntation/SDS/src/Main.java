import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {  // Infinite for loop (can also use while(true))
            System.out.println("Welcome to InvestEase!");
            System.out.println("------------------------");
            System.out.println(" select 1 to login ");
            System.out.println(" select 2 to signup ");
            System.out.println(" select 3 to exit ");
            System.out.println("------------------------");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline

                if (choice == 1) {
                    System.out.print("Enter User ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    Investor investor = new Investor(userID, password);
                    if (investor.login(userID, password)) {
                        investor.viewDashboard();
                        System.out.println("logging out");
                        System.out.println("closing program");
                        break;
                    }

                } else if (choice == 2) {
                    System.out.print("Enter User ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Investor investor = new Investor(userID, password, userName, email);
                    investor.signup(userID, password, userName, email);


                } else if (choice == 3) {
                    System.out.println("Thank you for using InvestEase!");
                    break;  // Exit the for loop
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}
