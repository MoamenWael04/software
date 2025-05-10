public class Asset {
    public String assetID;
    public String type;
    public double quantity;
    public double price;

    public Asset setAsset(String assetID, String type, double quantity, double price) {
        this.assetID = assetID;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        return this;
    }

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


    public String getAssetID() {
        return assetID;
    }

    public void printAsset() {
        System.out.println("The asset ID : " + assetID);
        System.out.println("The asset type : " + type);
        System.out.println("The asset quantity : " + quantity);
        System.out.println("The asset price : " + price);
        System.out.println("------------------------------");
    }
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