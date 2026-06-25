package gr.uom.parafarm.catalog;

import java.util.ArrayList;
import java.util.List;

import gr.uom.parafarm.model.SupplierOrder;

/**
 * Κατάλογος Παραγγελιών Προμηθευτή, απαιτούμενος ρητά από το σενάριο υλοποίησης
 * (βλ. σχόλιο τεκμηρίωσης στην SupplierOrder για τη σχέση της με το domain model
 * της Φάσης Ανάλυσης).
 */
public class SupplierOrderCatalogue {

    private List<SupplierOrder> supplierOrders = new ArrayList<>();

    public void addSupplierOrder(SupplierOrder so) {
        supplierOrders.add(so);
    }

    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrders;
    }
}
