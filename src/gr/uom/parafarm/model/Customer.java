package gr.uom.parafarm.model;

/**
 * Η κλάση Πελάτης δεν περιλαμβανόταν ούτε στο εννοιολογικό μοντέλο της Φάσης Ανάλυσης
 * (ενότητα 3.5.2) ούτε στο τελικό διάγραμμα κλάσεων (ενότητα 4.4), καθώς η πλευρά του
 * πελάτη είχε μοντελοποιηθεί έμμεσα μέσα από τις επιχειρηματικές διαδικασίες (Πώληση
 * Λιανικής, Καταχώρηση Παραγγελίας Χονδρικής) και όχι ως αυτοτελής οντότητα. Το σενάριο
 * υλοποίησης απαιτεί όμως ρητά αντικείμενο Πελάτη με στοιχεία τιμολόγησης (ΑΦΜ, ΔΟΥ),
 * απαραίτητα για την ορθή έκδοση παραστατικού (απόδειξη/τιμολόγιο). Πρόκειται για ρητή
 * υπόθεση/προσθήκη που τεκμηριώνεται εδώ σύμφωνα με τη γενική οδηγία 4 της εκφώνησης.
 */
public class Customer {

    private String name;
    private String customerType; // "Pharmacy" (χονδρική) ή "Retail" (λιανική)
    private String taxId;        // ΑΦΜ
    private String taxOffice;    // ΔΟΥ
    private String status;       // κατάσταση πελάτη (π.χ. "OK")

    public Customer(String name, String customerType, String taxId, String taxOffice, String status) {
        this.name = name;
        this.customerType = customerType;
        this.taxId = taxId;
        this.taxOffice = taxOffice;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getTaxId() {
        return taxId;
    }

    public void printData() {
        System.out.println("Customer -> Name: " + name + ", Type: " + customerType
                + ", Tax ID: " + taxId + ", Tax Office: " + taxOffice + ", Status: " + status);
    }
}
