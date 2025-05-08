import java.util.Scanner;

public class assetManager {
    private Asset[] assets;

    public assetManager() {
        this.assets = new Asset[15];
    }

    public boolean addAsset(Asset asset) {
        for (int i = 0; i < assets.length; i++) {
            if (assets[i] == null) {
                assets[i] = asset;
                return true;
            }
        }
        return false;
    }

    public void pickAsset(String assetID) {
        boolean flag = false; // track if asset was found
        for (Asset asset : assets) {
            if (asset != null && asset.getAssetID().equals(assetID)) { // Added null check & fixed string comparison
                System.out.println("Asset Details:");
                System.out.println(asset.assetID + " " + asset.type + " " + asset.quantity + " " + asset.price);
                flag = true; // Set flag to true when asset is found
                break; // Exit loop once found
            }
        }
        if (!flag) {
            System.out.println("Asset not found");
        }
    }

    public void displaylist() {
        for (Asset asset : assets) {
            if (asset != null) {
                asset.printlist();
            }
        }
    }

    public void editasset(String assetID) {
        boolean found = false; // Track if asset was found
        for (Asset asset : assets) {
            if (asset != null && asset.getAssetID().equals(assetID)) { // Added null check & fixed string comparison
                found = true; // Mark as found
                System.out.println("What do you want to edit:");
                System.out.println("1- type");
                System.out.println("2- quantity");
                System.out.println("3- price");
                Scanner scanner = new Scanner(System.in);
                int choice = 0;
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.println("Enter new type:");
                    String newtype = scanner.nextLine();
                    asset.type = newtype;
                    System.out.println("Type updated successfully");
                }
                else if (choice == 2) {
                    System.out.println("Enter new quantity:");
                    double newquantity = scanner.nextDouble();
                    asset.quantity = newquantity;
                    System.out.println("Quantity updated successfully");
                }
                else if (choice == 3) {
                    System.out.println("Enter new price:");
                    double newprice = scanner.nextDouble();
                    asset.price = newprice;
                    System.out.println("Price updated successfully");
                }
                else {
                    System.out.println("Invalid choice");
                }
                break; // Exit loop once found and edited
            }
        }

        if (!found) {
            System.out.println("Asset not found");
        }
    }

    public void removeAsset(String assetID) {
        boolean found = false;
        for (int i = 0; i < assets.length; i++) {
            if (assets[i] != null && assets[i].getAssetID().equals(assetID)) { // Added null check & fixed string comparison
                // Shift all following assets one position back
                for (int j = i; j < assets.length - 1; j++) {
                    assets[j] = assets[j + 1];
                }
                assets[assets.length - 1] = null; // Set the last element to null
                System.out.println("Asset removed successfully");
                found = true;
                return;
            }
        }

        if (!found) {
            System.out.println("Asset not found");
        }
    }
}