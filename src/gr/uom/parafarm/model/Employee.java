package gr.uom.parafarm.model;

/**
 * Η κλάση Υπάλληλος δεν εμφανίζεται αυτοτελώς στο τελικό διάγραμμα κλάσεων (ενότητα 4.4),
 * το οποίο μοντελοποιεί κάθε χρήστη του συστήματος μέσω της γενικής κλάσης User
 * (βλ. διαγράμματα ακολουθίας ΠΧ09 - Σύνδεση Χρήστη και ΠΧ10 - Διαχείριση Δικαιωμάτων
 * Χρηστών). Επειδή το σενάριο υλοποίησης απαιτεί ρητά αντικείμενα Υπαλλήλου με
 * ονοματεπώνυμο και ρόλο εταιρίας (π.χ. employee1("Antoniou","Warehouse","warehouse_user")),
 * η κλάση Employee επεκτείνει την User προσθέτοντας τα γνωρίσματα name και role. Το πεδίο
 * role τροφοδοτεί παράλληλα και το κληρονομημένο πεδίο rights, σύμφωνα με την απαίτηση
 * FR12 της ενότητας 3.3.2 («δικαιώματα πρόσβασης ανά ρόλο»).
 */
public class Employee extends User {

    private String name;
    private String role;

    public Employee(String name, String role, String accountUsername) {
        super(accountUsername, "", role);
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void printData() {
        System.out.println("Employee -> Name: " + name + ", Role: " + role
                + ", Account: " + getUsername());
    }
}
