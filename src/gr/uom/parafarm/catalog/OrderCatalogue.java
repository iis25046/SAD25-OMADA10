package gr.uom.parafarm.catalog;

import java.util.ArrayList;
import java.util.List;

import gr.uom.parafarm.model.Customer;
import gr.uom.parafarm.model.Employee;
import gr.uom.parafarm.model.Order;

/**
 * Αντιστοιχεί στην κλάση OrderCatalogue του τελικού διαγράμματος κλάσεων (ενότητα
 * 4.4): createOrder(), getPendingOrders(), archiveOrder().
 *
 * Η createOrder() στο διάγραμμα δεν δέχεται παραμέτρους· εδώ προστέθηκαν οι
 * παράμετροι customer/executedBy/orderType, καθώς χωρίς αυτά τα δεδομένα δεν είναι
 * δυνατή η ουσιαστική δημιουργία μιας έγκυρης Order σύμφωνα με το σενάριο (κάθε
 * παραγγελία απαιτεί πελάτη, υπάλληλο εκτέλεσης και τύπο παραγγελίας).
 *
 * Η removeOrder() δεν περιγράφεται καθόλου στο διάγραμμα κλάσεων, το οποίο (μέσω της
 * archiveOrder) προέβλεπε μόνο αρχειοθέτηση ολοκληρωμένων παραγγελιών. Το σενάριο
 * υλοποίησης απαιτεί όμως ρητά την πλήρη διαγραφή της order2, ώστε να προσομοιωθεί
 * ακύρωση πριν αυτή προωθηθεί σε αποθήκη/λογιστήριο - μια διαφορετική περίπτωση
 * κύκλου ζωής που δεν είχε προβλεφθεί στα διαγράμματα ακολουθίας της Φάσης Σχεδίασης.
 */
public class OrderCatalogue {

    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Customer customer, Employee executedBy, String orderType) {
        Order o = new Order(customer, executedBy, orderType);
        orders.add(o);
        return o;
    }

    public List<Order> getPendingOrders() {
        List<Order> pending = new ArrayList<>();
        for (Order o : orders) {
            if (o.getStatus().equals("OPEN")) {
                pending.add(o);
            }
        }
        return pending;
    }

    public void archiveOrder(Order o) {
        o.updateStatus("ARCHIVED");
    }

    public void removeOrder(Order o) {
        o.cancel();
        orders.remove(o);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
