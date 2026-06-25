package gr.uom.parafarm;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import gr.uom.parafarm.catalog.CustomerCatalogue;
import gr.uom.parafarm.catalog.EmployeeCatalogue;
import gr.uom.parafarm.catalog.OrderCatalogue;
import gr.uom.parafarm.catalog.ProductCatalogue;
import gr.uom.parafarm.catalog.SupplierOrderCatalogue;
import gr.uom.parafarm.model.Customer;
import gr.uom.parafarm.model.Document;
import gr.uom.parafarm.model.Employee;
import gr.uom.parafarm.model.Order;
import gr.uom.parafarm.model.Product;
import gr.uom.parafarm.model.Supplier;
import gr.uom.parafarm.model.SupplierOrder;

/**
 * Πρόγραμμα οδήγησης (driver) που υλοποιεί το σενάριο δοκιμής/επίδειξης της
 * εκφώνησης (ενότητα "Σενάριο προς υλοποίηση"), με βάση το τελικό διάγραμμα κλάσεων
 * (ενότητα 4.4) και τα διαγράμματα ακολουθίας (ενότητα 4.3) της Φάσης Σχεδίασης.
 */
public class ParaFarmApp {

    public static void main(String[] args) {

        // Αναγκαστική χρήση UTF-8 στην έξοδο: χωρίς αυτό, σε Windows τερματικά με
        // προεπιλεγμένη κωδικοσελίδα (π.χ. cmd/PowerShell χωρίς "chcp 65001"), τα
        // ελληνικά κείμενα της εφαρμογής εμφανίζονται ως παραμορφωμένοι χαρακτήρες.
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        ProductCatalogue productCatalogue = new ProductCatalogue();
        CustomerCatalogue customerCatalogue = new CustomerCatalogue();
        EmployeeCatalogue employeeCatalogue = new EmployeeCatalogue();
        OrderCatalogue orderCatalogue = new OrderCatalogue();
        SupplierOrderCatalogue supplierOrderCatalogue = new SupplierOrderCatalogue();
        Supplier mainSupplier = new Supplier("PharmaSupply AE", "2310123456");

        System.out.println("--- ParaFarm System Simulation ---\n");

        // ---------------- Προϊόντα ----------------
        Product product1 = new Product("Thermometer", "paramedical", 12.50, 80, 30);
        productCatalogue.addProduct(product1);
        System.out.println("Object product1 has been created.");

        Product product2 = new Product("Shoes", "paramedical", 35.00, 45, 20);
        productCatalogue.addProduct(product2);
        System.out.println("Object product2 has been created.");

        Product product3 = new Product("Cream", "cosmetic", 18.00, 25, 40);
        productCatalogue.addProduct(product3);
        System.out.println("Object product3 has been created.");

        Product product4 = new Product("makeup", "cosmetic", 22.00, 60, 25);
        productCatalogue.addProduct(product4);
        System.out.println("Object product4 has been created.");

        // ---------------- Πελάτες ----------------
        Customer customer1 = new Customer("Farmakeio Papadopoulou", "Pharmacy", "099845210", "DOY Kalamarias", "OK");
        customerCatalogue.addCustomer(customer1);
        System.out.println("Object customer1 has been created.");

        Customer customer2 = new Customer("Farmakeio Nikolaidis", "Pharmacy", "078632145", "DOY Evosmou", "OK");
        customerCatalogue.addCustomer(customer2);
        System.out.println("Object customer2 has been created.");

        Customer customer3 = new Customer("Georgiou Maria", "Retail", "112233445", "DOY Thessalonikis", "OK");
        customerCatalogue.addCustomer(customer3);
        System.out.println("Object customer3 has been created.");

        // ---------------- Υπάλληλοι ----------------
        Employee employee1 = new Employee("Antoniou", "Warehouse", "warehouse_user");
        employeeCatalogue.addEmployee(employee1);
        System.out.println("Object employee1 has been created.");

        Employee employee2 = new Employee("Eleftheriou", "Customer Service", "service_user");
        employeeCatalogue.addEmployee(employee2);
        System.out.println("Object employee2 has been created.");

        Employee employee3 = new Employee("Sotiriou", "Cashier", "cashier_user");
        employeeCatalogue.addEmployee(employee3);
        System.out.println("Object employee3 has been created.");

        Employee employee4 = new Employee("Seller1", "Sales", "sales_user");
        employeeCatalogue.addEmployee(employee4);
        System.out.println("Object employee4 has been created.\n");

        // ---------------- Παραγγελίες ----------------
        Order order1 = orderCatalogue.createOrder(customer1, employee4, "WHOLESALE");
        order1.addProduct(product1, 10);
        order1.addProduct(product3, 5);
        issueDocument(order1);
        System.out.println("Object order1 has been created and registered.\n");

        Order order2 = orderCatalogue.createOrder(customer1, employee4, "WHOLESALE");
        order2.addProduct(product2, 8);
        order2.addProduct(product4, 12);
        issueDocument(order2);
        System.out.println("Object order2 has been created and registered.\n");

        Order order3 = orderCatalogue.createOrder(customer2, employee4, "WHOLESALE");
        order3.addProduct(product3, 20);
        order3.addProduct(product4, 10);
        order3.addProduct(product1, 6);
        issueDocument(order3);
        System.out.println("Object order3 has been created and registered.\n");

        Order order4 = orderCatalogue.createOrder(customer3, employee3, "RETAIL");
        order4.addProduct(product1, 1);
        order4.addProduct(product4, 2);
        issueDocument(order4);
        System.out.println("Object order4 has been created and registered.\n");

        // ---------------- Ακύρωση order2 ----------------
        // Προσομοιώνει ακύρωση παραγγελίας φαρμακείου πριν αυτή προωθηθεί στην
        // αποθήκη και στο λογιστήριο: το δεσμευμένο απόθεμα επιστρέφεται (Order.cancel()).
        orderCatalogue.removeOrder(order2);
        System.out.println("Object order2 has been deleted (cancelled before reaching warehouse/accounting).\n");

        // ---------------- Αναπλήρωση Αποθέματος ----------------
        List<Product> lowStock = productCatalogue.checkLowStock();
        for (Product p : lowStock) {
            int qtyToOrder = 50; // σύμφωνα με το παράδειγμα της εκφώνησης (supplierOrder1 -> product3)
            SupplierOrder so = new SupplierOrder(p, qtyToOrder, mainSupplier,
                    "Stock quantity fell below the safety limit");
            supplierOrderCatalogue.addSupplierOrder(so);
            System.out.println("Object supplierOrder" + so.getOrderId()
                    + " has been created automatically for " + p.getName() + ".");
        }

        // ---------------- Τελική εκτύπωση καταλόγων ----------------
        System.out.println("\n=== Κατάλογος Προϊόντων ===");
        for (Product p : productCatalogue.getAllProducts()) {
            p.printData();
        }

        System.out.println("\n=== Κατάλογος Πελατών ===");
        for (Customer c : customerCatalogue.getAllCustomers()) {
            c.printData();
        }

        System.out.println("\n=== Κατάλογος Υπαλλήλων ===");
        for (Employee e : employeeCatalogue.getAllEmployees()) {
            e.printData();
        }

        System.out.println("\n=== Κατάλογος Παραγγελιών ===");
        for (Order o : orderCatalogue.getAllOrders()) {
            o.printData();
        }

        System.out.println("\n=== Κατάλογος Παραγγελιών Προμηθευτή ===");
        for (SupplierOrder so : supplierOrderCatalogue.getAllSupplierOrders()) {
            so.printData();
        }
    }

    private static void issueDocument(Order order) {
        Document doc = new Document();
        doc.generate(order);
        doc.sendToAccounting();
        doc.print();
    }
}
