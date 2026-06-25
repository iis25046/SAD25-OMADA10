package gr.uom.parafarm.model;

/**
 * Η κλάση Προμηθευτής είχε οριστεί στο εννοιολογικό μοντέλο της Φάσης Ανάλυσης
 * (ενότητα 3.5.2 - επωνυμία, τηλέφωνο) αλλά δεν περιλαμβανόταν ρητά στο τελικό
 * διάγραμμα κλάσεων της Φάσης Σχεδίασης (ενότητα 4.4). Υλοποιείται εκ νέου εδώ, με τα
 * ίδια γνωρίσματα του αρχικού domain model, καθώς είναι απαραίτητη για το σενάριο της
 * αυτόματης αναπλήρωσης αποθέματος (βλ. και διάγραμμα αντικειμένων 3.6, όπου
 * χρησιμοποιείται ο προμηθευτής "PharmaSupply AE").
 */
public class Supplier {

    private String name;  // Επωνυμία
    private String phone; // Τηλέφωνο

    public Supplier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}
