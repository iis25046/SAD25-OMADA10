package gr.uom.parafarm.model;

import java.util.Date;

/**
 * Η κλάση Παραγγελία Προμηθευτή είχε οριστεί στο εννοιολογικό μοντέλο της Φάσης
 * Ανάλυσης (ενότητα 3.5.2 - Κωδικός Αναπλήρωσης, Ημερομηνία, Κατάσταση) αλλά δεν
 * περιλαμβανόταν ρητά στο τελικό διάγραμμα κλάσεων (ενότητα 4.4), το οποίο
 * επικεντρώθηκε στις ροές πώλησης (ΠΧ01-ΠΧ07, ΠΧ09, ΠΧ10). Υλοποιείται εκ νέου εδώ
 * καθώς είναι απολύτως απαραίτητη για το σενάριο της αυτόματης αναπλήρωσης
 * αποθέματος (ΠΧ08 - Αυτόματη Παραγγελία Προμηθευτή). Το γνώρισμα reason προστέθηκε
 * επιπλέον επειδή το ίδιο το σενάριο υλοποίησης απαιτεί ρητά η printData() να
 * εμφανίζει "τον λόγο δημιουργίας της παραγγελίας".
 */
public class SupplierOrder {

    private static int counter = 1;

    private int orderId; // Κωδικός Αναπλήρωσης
    private Date date;
    private String status;
    private Product product;
    private int quantity;
    private Supplier supplier;
    private String reason;

    public SupplierOrder(Product product, int quantity, Supplier supplier, String reason) {
        this.orderId = counter++;
        this.date = new Date();
        this.status = "PENDING";
        this.product = product;
        this.quantity = quantity;
        this.supplier = supplier;
        this.reason = reason;
    }

    public int getOrderId() {
        return orderId;
    }

    public void printData() {
        System.out.println("SupplierOrder #" + orderId + " -> Product: " + product.getName()
                + ", Quantity: " + quantity + ", Reason: " + reason
                + ", Supplier: " + supplier.getName() + ", Status: " + status);
    }
}
