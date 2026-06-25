package gr.uom.parafarm.model;

import java.util.Date;

/**
 * Αντιστοιχεί ακριβώς στην κλάση Document του τελικού διαγράμματος κλάσεων (ενότητα
 * 4.4) και υλοποιεί την αφήγηση σχεδίασης ΠΧ05 (Έκδοση Απόδειξης/Τιμολογίου): ο τύπος
 * παραστατικού προκύπτει από τον τύπο της παραγγελίας (FR02), συνεπώς δεν χρειάστηκε
 * καμία πρόσθετη υπόθεση πέραν όσων ορίζει το διάγραμμα.
 */
public class Document {

    private static int counter = 1;

    private int docID;
    private String type;
    private double amount;
    private Date date;

    public void generate(Order o) {
        this.docID = counter++;
        this.type = o.getOrderType().equals("WHOLESALE") ? "INVOICE" : "RECEIPT";
        this.amount = o.calculateTotal();
        this.date = new Date();
    }

    public void sendToAccounting() {
        System.out.println("Document #" + docID + " (" + type + ") sent to accounting system. Amount: "
                + amount + " EUR");
    }

    public void print() {
        System.out.println("===== " + type + " #" + docID + " =====");
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount + " EUR");
        System.out.println("=========================");
    }
}
