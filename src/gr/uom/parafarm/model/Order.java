package gr.uom.parafarm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Αντιστοιχεί στην κλάση Order του τελικού διαγράμματος κλάσεων (ενότητα 4.4): τα
 * γνωρίσματα orderID, orderDate, status, orderType και οι μέθοδοι addProduct(),
 * updateStatus(), calculateTotal() είναι αυτά που ορίζονται εκεί.
 *
 * Τα γνωρίσματα customer και executedBy ΔΕΝ εμφανίζονται ως ρητά attributes στο
 * διάγραμμα, είναι όμως απαραίτητα: το σενάριο υλοποίησης ζητά κάθε Παραγγελία να
 * συνδέεται με τον πελάτη που την υπέβαλε και τον υπάλληλο που την εκτέλεσε, σχέση
 * που στα διαγράμματα ακολουθίας (ΠΧ01 - Καταχώρηση Παραγγελίας, ΠΧ04 - Πώληση στο
 * Ταμείο) εμφανίζεται μέσω των actors "πωλητής"/"ταμίας" αλλά δεν είχε αποτυπωθεί ως
 * γνώρισμα στο class diagram.
 */
public class Order {

    private static int counter = 1;

    private int orderID;
    private Date orderDate;
    private String status;
    private String orderType; // "WHOLESALE" ή "RETAIL" -> καθορίζει τύπο παραστατικού (FR02)
    private List<OrderItem> items = new ArrayList<>();
    private Customer customer;
    private Employee executedBy;

    public Order(Customer customer, Employee executedBy, String orderType) {
        this.orderID = counter++;
        this.orderDate = new Date();
        this.status = "OPEN";
        this.orderType = orderType;
        this.customer = customer;
        this.executedBy = executedBy;
    }

    /** Καταχωρίζει προϊόν στην παραγγελία και μειώνει αντίστοιχα το απόθεμά του (ΠΧ02 - Εκτέλεση Παραγγελίας). */
    public void addProduct(Product p, int qty) {
        items.add(new OrderItem(p, qty));
        p.updateStock(-qty);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getLineTotal();
        }
        return total;
    }

    /**
     * Δεν περιγράφεται στο διάγραμμα κλάσεων. Προστέθηκε επειδή το σενάριο υλοποίησης
     * απαιτεί ρητά τη διαγραφή της order2 ως ακύρωση πριν αυτή προωθηθεί σε αποθήκη και
     * λογιστήριο - οπότε το δεσμευμένο απόθεμα των προϊόντων της πρέπει να επιστραφεί.
     */
    public void cancel() {
        for (OrderItem item : items) {
            item.getProduct().updateStock(item.getQuantity());
        }
        this.status = "CANCELLED";
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getExecutedBy() {
        return executedBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getStatus() {
        return status;
    }

    public void printData() {
        String documentType = orderType.equals("WHOLESALE") ? "INVOICE" : "RECEIPT";
        System.out.println("Order #" + orderID + " -> Customer Tax ID: " + customer.getTaxId()
                + ", Document Type: " + documentType
                + ", Executed by: " + executedBy.getName() + ", Status: " + status);
        for (OrderItem item : items) {
            System.out.println("      - " + item.getProduct().getName() + " x" + item.getQuantity());
        }
    }
}
