# ParaFarm

Πληροφοριακό σύστημα διαχείρισης παραγγελιών, αποθέματος και πελατών για την επιχείρηση
παραφαρμακευτικών «ParaFarm» — υλοποίηση σε Java βασισμένη στην ανάλυση και σχεδίαση UML
του μαθήματος **Ανάλυση και Σχεδίαση Συστημάτων** (Πανεπιστήμιο Μακεδονίας, Τμήμα
Εφαρμοσμένης Πληροφορικής, Ομάδα 10, Ακαδημαϊκό Έτος 2025-2026).

## Δομή

- `src/gr/uom/parafarm/model` — οντότητες (Product, Customer, Employee, Order, OrderItem,
  Document, Supplier, SupplierOrder, User)
- `src/gr/uom/parafarm/catalog` — κατάλογοι (ProductCatalogue, CustomerCatalogue,
  EmployeeCatalogue, OrderCatalogue, SupplierOrderCatalogue)
- `src/gr/uom/parafarm/ParaFarmApp.java` — πρόγραμμα οδήγησης (main) με το σενάριο δοκιμής

## Εκτέλεση

**Από IDE (Eclipse/VS Code):** Run `ParaFarmApp.java` (πακέτο `gr.uom.parafarm`).

**Από terminal (Linux/GCP VM):**
```bash
java -jar ParaFarm.jar
```

**Σε Windows, διπλό κλικ:** `Run_ParaFarm.bat`

## Ομάδα 10

| Ονοματεπώνυμο | ΑΜ |
|---|---|
| Κουμπουλίδου Δήμητρα | iis25092 |
| Αντωνακούδη Ευγενία | iis25191 |
| Τσάμης Ιωάννης | iis25046 |
| Τσίχλης Απόστολος | iis25021 |
| Χουρουζίδου Ξανθίππη | iis25033 |
