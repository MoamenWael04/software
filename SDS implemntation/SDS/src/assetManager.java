import java.util.Scanner;
// n8er asm el class "assetManager"

public class assetManager {
    private Asset[] assets; // hnzwd fe class diagram

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
    public Asset pickAsset(String assetID) {   // print asset's characterstics
        for (Asset asset : assets) {
            if (asset.getAssetID() == assetID) {
                asset.printAsset();
                return asset;
            }
        }
        return null;
    }


public void displaylist()   // printing all assets IDs
{
    for (Asset asset : assets) {
        if (asset != null) {
            asset.printlist();// elmafrood y8er el id bs
        }
    }
}
public void editasset(String assetID)
{
    for (Asset asset : assets) {
        if (asset.getAssetID() == assetID) {
            System.out.println("what do you want to edit");
            System.out.println("1- type");
            System.out.println("2- quantity");
            System.out.println("3- price");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("enter new type");
                String newtype = scanner.nextLine();
                asset.type = newtype;
            }
            else if (choice == 2) {
                System.out.println("enter new quantity");
                double newquantity = scanner.nextDouble();
                asset.quantity = newquantity;
            }
            else if (choice == 3) {
                System.out.println("enter new price");
                double newprice = scanner.nextDouble();
                asset.price = newprice;
            }
            else {
                System.out.println("invalid choice");
            }
        }
    }
}
    public void removeAsset(String assetID) {
        boolean found = false;
        for (int i = 0; i < assets.length; i++) {
            if ( assets[i].getAssetID().equals(assetID)) {
                // Shift all following assets one position back
                for (int j = i; j < assets.length - 1; j++) {
                    assets[j] = assets[j + 1];
                }
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








