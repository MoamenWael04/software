import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zakah_Compliance {
    private assetManager manager;

    public Zakah_Compliance(assetManager manager) {
        this.manager = manager;
    }

    public void zakatMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("=== Zakat & Compliance ===");
            System.out.println("1. Calculate Zakat for All Assets");
            System.out.println("2. Calculate Zakat for a Specific Asset");
            System.out.println("3. Download Zakat Report (.txt)");
            System.out.println("4. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    calculateZakatForAllAssets();
                    break;
                case 2:
                    calculateZakatForAssetByID();
                    break;
                case 3:
                    generateZakatTextReport();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void calculateZakatForAllAssets() {
        ArrayList<Asset> assets = manager.getAssets();
        if (assets.isEmpty()) {
            System.out.println("No portfolio found. Please add your investments first.");
            return;
        }

        double totalZakat = 0;
        System.out.println("Zakat Calculation Summary:");
        for (Asset asset : assets) {
            double zakat = asset.calculateZakat();
            System.out.println("Asset ID: " + asset.assetID + ", Type: " + asset.type +
                    ", Zakat Due: " + zakat);
            System.out.println("-----------------------------");
            totalZakat += zakat;
        }

        System.out.println("Total Zakat Due: " + totalZakat);
    }
    private void calculateZakatForAssetByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Asset ID: ");
        String assetID = scanner.nextLine();

        ArrayList<Asset> assets = manager.getAssets();
        boolean found = false;

        for (Asset asset : assets) {
            if (asset.getAssetID().equalsIgnoreCase(assetID)) {
                double zakat = asset.calculateZakat();
                System.out.println("Asset ID: " + asset.assetID);
                System.out.println("Type: " + asset.type);
                System.out.println("Quantity: " + asset.quantity);
                System.out.println("Price: " + asset.price);
                System.out.println("Zakat Due: " + zakat);
                System.out.println("-----------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Asset not found. Please check the ID and try again.");
        }
    }

    public void generateZakatTextReport() {
        ArrayList<Asset> assets = manager.getAssets();

        if (assets.isEmpty()) {
            System.out.println("No portfolio found. Please add your investments first.");
            return;
        }

        double totalZakat = 0;
        String fileName = "zakat_report.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== Zakat Report ===\n");
            for (Asset asset : assets) {
                double zakat = asset.calculateZakat();
                writer.write("Asset ID: " + asset.assetID + "\n");
                writer.write("Type: " + asset.type + "\n");
                writer.write("Quantity: " + asset.quantity + "\n");
                writer.write("Price: " + asset.price + "\n");
                writer.write("Zakat Due: " + zakat + "\n");
                writer.write("-----------------------------\n");
                totalZakat += zakat;
            }
            writer.write("Total Zakat Due: " + totalZakat + "\n");

            System.out.println("Zakat report saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Error generating Zakat report: " + e.getMessage());
        }
    }
}
