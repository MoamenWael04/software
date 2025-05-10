/**
 * Represents a financial asset within the InvestEase system.
 * This class manages asset properties and provides validation methods
 * to ensure data integrity.
 */
public class Asset {
    /** Unique identifier for the asset */
    public String assetID;

    /** Type of asset (crypto, gold, stock, or real estate) */
    public String type;

    /** Quantity of the asset owned */
    public double quantity;

    /** Current price per unit of the asset */
    public double price;

    /**
     * Sets the properties of this asset.
     *
     * @param assetID  The unique identifier for the asset
     * @param type     The type of asset (crypto, gold, stock, or real estate)
     * @param quantity The quantity of the asset owned
     * @param price    The current price per unit of the asset
     * @return         The asset object with updated properties
     */
    public Asset setasset(String assetID, String type, double quantity, double price) {
        this.assetID = assetID;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        return this;
    }

    /**
     * Validates that all asset properties meet required constraints.
     * Constraints checked:
     * - assetID must be alphanumeric
     * - type must be one of: crypto, gold, stock, or real estate
     * - quantity must be greater than 0
     * - price must not be negative
     *
     * @return true if all properties are valid, false otherwise
     */
    public boolean verifyAsset() {
        boolean isValid = true;

        if (!assetID.matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid Asset ID: must be alphanumeric.");
            isValid = false;
        }

        if (!(type.equalsIgnoreCase("crypto") ||
                type.equalsIgnoreCase("gold") ||
                type.equalsIgnoreCase("stock") ||
                type.equalsIgnoreCase("real estate"))) {
            System.out.println("Invalid Asset Type: must be one of crypto, gold, stock, or real estate.");
            isValid = false;
        }

        if (quantity <= 0) {
            System.out.println("Invalid Quantity: must be greater than 0.");
            isValid = false;
        }

        if (price < 0) {
            System.out.println("Invalid Price: cannot be negative.");
            isValid = false;
        }

        return isValid;
    }


    /**
     * Gets the asset's unique identifier.
     *
     * @return The asset ID
     */
    public String getAssetID() {
        return assetID;
    }

    /**
     * Prints the asset details to the console.
     */
    public void printAsset() {
        System.out.println("The asset ID : " + assetID);
        System.out.println("The asset type : " + type);
        System.out.println("The asset quantity : " + quantity);
        System.out.println("The asset price : " + price);
        System.out.println("------------------------------");
    }

    /**
     * Calculates the zakat (Islamic charity) amount due on this asset.
     * Calculation is based on asset type and value:
     * - Gold, crypto, and stocks: 2.5% of total value
     * - Real estate: zakat applies only if held for resale
     *
     * @return The calculated zakat amount
     */
    public double calculateZakat() {
        double totalValue = quantity * price;

        switch (type.toLowerCase()) {
            case "gold":
            case "crypto":
            case "stock":
                return totalValue * 0.025;

            case "real estate":
                // Assume only resale properties are zakatable
                System.out.println("Note: Zakat is only due on real estate held for resale.");
                return 0;

            default:
                System.out.println("Unknown asset type for zakat calculation.");
                return 0;
        }
    }
}