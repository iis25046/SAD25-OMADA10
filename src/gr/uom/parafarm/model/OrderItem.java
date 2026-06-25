package gr.uom.parafarm.model;

/**
 * Αντιστοιχεί στην κλάση OrderItem του τελικού διαγράμματος κλάσεων (ενότητα 4.4).
 * Το γνώρισμα product (αναφορά στο Product) δεν αναγράφεται ως ρητό attribute στο
 * διάγραμμα, προκύπτει όμως άμεσα από τη γραμμή συσχέτισης OrderItem - Product (1)
 * που απεικονίζεται σε αυτό.
 */
public class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLineTotal() {
        return product.getPrice() * quantity;
    }
}
