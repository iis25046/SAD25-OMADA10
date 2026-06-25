package gr.uom.parafarm.catalog;

import java.util.ArrayList;
import java.util.List;

import gr.uom.parafarm.model.Employee;

/**
 * Κατάλογος Υπαλλήλων. Αναλαμβάνει επίσης τον ρόλο της κλάσης UserCatalogue του
 * τελικού διαγράμματος κλάσεων (verifyCredentials, getRights), καθώς οι μοναδικοί
 * χρήστες (User) που εμφανίζονται στο σενάριο υλοποίησης είναι Υπάλληλοι (η Employee
 * επεκτείνει την User - βλ. σχόλιο τεκμηρίωσης στην Employee).
 */
public class EmployeeCatalogue {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public boolean verifyCredentials(String username, String password) {
        for (Employee e : employees) {
            if (e.getUsername().equals(username)) {
                return e.checkPassword(password);
            }
        }
        return false;
    }

    public String getRights(String username) {
        for (Employee e : employees) {
            if (e.getUsername().equals(username)) {
                return e.getRights();
            }
        }
        return null;
    }
}
