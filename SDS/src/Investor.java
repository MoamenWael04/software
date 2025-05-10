import java.util.Scanner;

/**
 * Represents an investor user of the InvestEase system.
 * Extends the base User class with investor-specific functionality.
 */
public class Investor extends User {

    /**
     * Constructs a new Investor with full user details.
     *
     * @param userID   The user ID for this investor
     * @param userName The name of this investor
     * @param email    The email of this investor
     * @param password The password for this investor
     */
    Investor(String userID, String userName, String email, String password)
    {
        super(userID, userName, email, password);
    }

    /**
     * Constructs a new Investor with minimal details for login.
     *
     * @param userID   The user ID for this investor
     * @param password The password for this investor
     */
    Investor(String userID, String password)
    {
        super(userID, password);
    }

    /**
     * Displays the investor dashboard and handles user navigation through the system.
     * Provides access to asset management, zakat calculations, and financial reports.
     */
    public void viewDashboard() {
        Scanner scanner = new Scanner(System.in);
        boolean mainRunning = true;
        assetManager manager = new assetManager();

        while (mainRunning)
        {
            System.out.println( "Welcome " + this.UserID);
            System.out.println("Please select an option");
            System.out.println("1- Asset managment");
            System.out.println("2- zakat & Compliance");
            System.out.println("3- Reports & Insights");
            System.out.println("4- Logout");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (choice == 1) {
                boolean running = true;
                while (running) {
                    System.out.println("\nAsset Management System");
                    System.out.println("1. Add new asset");
                    System.out.println("2. Display all assets");
                    System.out.println("3. Search for an asset");
                    System.out.println("4. Edit an asset");
                    System.out.println("5. Remove an asset");
                    System.out.println("6. Exit");
                    System.out.print("Enter your choice: ");

                    int choice2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice2) {
                        case 1:
                            System.out.println("Enter asset details:");
                            System.out.print("Asset ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Type: ");
                            String type = scanner.nextLine();
                            System.out.print("Quantity: ");
                            double quantity = scanner.nextDouble();
                            System.out.print("Price: ");
                            double price = scanner.nextDouble();

                            Asset newAsset = new Asset().setasset(id, type, quantity, price);
                            if (manager.addAsset(newAsset)) {
                                continue;
                            } else {
                                System.out.println("Failed to add the asset (Invalid details)");
                            }
                            break;

                        case 2:
                            manager.displaylist();
                            break;

                        case 3:
                            System.out.print("Enter asset ID to search: ");
                            String searchId = scanner.nextLine();
                            manager.pickAsset(searchId);
                            break;

                        case 4:
                            manager.displaylist();
                            System.out.print("Enter asset ID to edit: ");
                            String editId = scanner.nextLine();
                            manager.editasset(editId);
                            break;

                        case 5:
                            manager.displaylist();
                            System.out.print("Enter asset ID to remove: ");
                            String removeId = scanner.nextLine();
                            manager.removeAsset(removeId);
                            break;

                        case 6:
                            running = false;
                            System.out.println("Thank you for using Asset Management System!");
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }

                }
            }
            else if (choice == 2)
            {
                Zakah_Compliance zakahCompliance = new Zakah_Compliance(manager);
                zakahCompliance.zakatMenu();
            }
            else if(choice == 3)
            {
                Reports_Insights reports = new Reports_Insights(manager);
                reports.reportMenu();
            }
            else if (choice == 4) {
                mainRunning = false;
            }
            else {
                System.out.println("Invalid choice! Please try again.");
            }

        }

        scanner.close();
    }
}