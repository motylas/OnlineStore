public class Product {
    public String description;
    public String seller;
    public String country;
    public int quantity;
    public float pricePerUnit;

    public Product(String description, String seller, String country, int quantity, float pricePerUnit) {
        this.description = description;
        this.seller = seller;
        this.country = country;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}
