package gr.uom.parafarm.model;

/**
 * Αντιστοιχεί ακριβώς στην κλάση Product του τελικού διαγράμματος κλάσεων (ενότητα 4.4),
 * εμπλουτισμένη με τη μέθοδο printData() που απαιτείται ρητά από το σενάριο υλοποίησης
 * (όχι από το διάγραμμα κλάσεων - πρόκειται για απαίτηση δοκιμής/επίδειξης).
 */
public class Product {

    private static int counter = 1;

    private int productID;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private int safetyLimit;

    public Product(String name, String category, double price, int stockQuantity, int safetyLimit) {
        this.productID = counter++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.safetyLimit = safetyLimit;
    }

    public int getStock() {
        return stockQuantity;
    }

    /** Θετική τιμή = αύξηση αποθέματος (παραλαβή/ακύρωση παραγγελίας), αρνητική = μείωση (πώληση). */
    public void updateStock(int qty) {
        this.stockQuantity += qty;
    }

    public void setSafetyLimit(int limit) {
        this.safetyLimit = limit;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getProductID() {
        return productID;
    }

    public boolean isBelowSafetyLimit() {
        return stockQuantity < safetyLimit;
    }

    public void printData() {
        System.out.println("Product -> Name: " + name + ", Category: " + category
                + ", Price: " + price + " EUR, Stock: " + stockQuantity
                + ", Safety Limit: " + safetyLimit);
    }
}
