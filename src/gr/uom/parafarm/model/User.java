package gr.uom.parafarm.model;

/**
 * Αντιστοιχεί ακριβώς στην κλάση User του τελικού διαγράμματος κλάσεων (ενότητα 4.4
 * του παραδοτέου), όπως προέκυψε από τα διαγράμματα ακολουθίας ΠΧ09 (Σύνδεση Χρήστη)
 * και ΠΧ10 (Διαχείριση Δικαιωμάτων Χρηστών).
 */
public class User {

    protected String username;
    protected String password;
    protected String rights;

    public User(String username, String password, String rights) {
        this.username = username;
        this.password = password;
        this.rights = rights;
    }

    public boolean checkPassword(String password) {
        return this.password != null && this.password.equals(password);
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String newRights) {
        this.rights = newRights;
    }

    public String getUsername() {
        return username;
    }
}
