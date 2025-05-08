import java.util.Scanner;

public class Investor extends User {
    Investor(String userID, String userName, String email, String password)
    {
        super(userID, userName, email, password);
    }
    Investor(String userID, String password)
    {
        super(userID, password);
    }
    public void viewDashboard() {
        Scanner scanner = new Scanner(System.in);
        boolean mainRunning = true;

        while (mainRunning)
        {
        System.out.println( "Hello " + this.UserID);
        System.out.println("please select an option");
        System.out.println("1- asset managment");
        System.out.println("2- zakat");
        System.out.println("3- logout");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice == 1) {
            assetManager manager = new assetManager();
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
                            System.out.println("Asset added successfully!");
                        } else {
                            System.out.println("Asset list is full!");
                        }
                        break;

                    case 2:
                        System.out.println("\nAsset List:");
                        manager.displaylist();
                        break;

                    case 3:
                        System.out.print("Enter asset ID to search: ");
                        String searchId = scanner.nextLine();
                        manager.pickAsset(searchId);
                        break;

                    case 4:
                        System.out.print("Enter asset ID to edit: ");
                        String editId = scanner.nextLine();
                        manager.editasset(editId);
                        break;

                    case 5:
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
        else if (choice == 2) {}
        else if (choice == 3) {
            mainRunning = false;
        }
        else {
            System.out.println("Invalid choice! Please try again.");
        }

    }

        scanner.close();
    }
}
