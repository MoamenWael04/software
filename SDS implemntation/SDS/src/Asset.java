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
        return assetID != "0"  && type != null && quantity > 0 && price >= 0; // type yb2a haga mn el arb3a
    }

    public String getAssetID() {
        return assetID;
    }
    public void printlist()
    {
        System.out.println("ISD : ");
        System.out.printf("  " + assetID);
    }

    public void printAsset()
    {
        System.out.println("Asset ID: " + this.assetID);
        System.out.println("Type: " + this.type);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + this.price);
    }

}
