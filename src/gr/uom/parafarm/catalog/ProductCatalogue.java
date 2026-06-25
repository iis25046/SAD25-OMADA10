package gr.uom.parafarm.catalog;

import java.util.ArrayList;
import java.util.List;

import gr.uom.parafarm.model.Product;

/**
 * Αντιστοιχεί ακριβώς στην κλάση ProductCatalogue του τελικού διαγράμματος κλάσεων
 * (ενότητα 4.4): findProduct(), getAllProducts(), checkLowStock(). Η εσωτερική λίστα
 * products και η addProduct() είναι αναγκαία προσθήκη -χωρίς αυτή δεν θα μπορούσε να
 * υλοποιηθεί κανένας Κατάλογος- συνεπώς δεν θεωρείται απόκλιση από το διάγραμμα.
 */
public class ProductCatalogue {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public Product findProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> checkLowStock() {
        List<Product> low = new ArrayList<>();
        for (Product p : products) {
            if (p.isBelowSafetyLimit()) {
                low.add(p);
            }
        }
        return low;
    }
}
