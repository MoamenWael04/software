public class Asset {
    public String assetID;
    public String type;
    public double quantity;
    public double price;

    public Asset setasset(String assetID, String type, double quantity, double price) {
        this.assetID = assetID;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        return this;
    }

    public boolean verifyAsset() {
        // Fixed string comparison to use !equals() instead of !=
        return assetID != null && !assetID.equals("0") && type != null && quantity > 0 && price >= 0;
    }

    public String getAssetID() {
        return assetID;
    }

    public void printlist() {
        System.out.println(assetID);
    }
}