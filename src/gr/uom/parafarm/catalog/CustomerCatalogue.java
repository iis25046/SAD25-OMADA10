package gr.uom.parafarm.catalog;

import java.util.ArrayList;
import java.util.List;

import gr.uom.parafarm.model.Customer;

/**
 * Κατάλογος Πελατών. Δεν εμφανίζεται στο τελικό διάγραμμα κλάσεων (αφού δεν υπάρχει
 * εκεί η κλάση Customer - βλ. σχόλιο τεκμηρίωσης στην Customer), αλλά απαιτείται ρητά
 * από το σενάριο υλοποίησης ("Κατάλογος Πελατών").
 */
public class CustomerCatalogue {

    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
