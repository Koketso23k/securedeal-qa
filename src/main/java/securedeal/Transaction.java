package securedeal;

/**
 * One SecureDeal transaction: who is buying, what the item is,
 * how much it costs, and where the deal is up to.
 */
public class Transaction {

    private final String buyerName;
    private final String itemName;
    private final double price;
    private TransactionStatus status;

    public Transaction(String buyerName, String itemName, double price) {
        if (buyerName == null || buyerName.isBlank()) {
            throw new IllegalArgumentException("Buyer name cannot be empty");
        }
        if (itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be more than zero");
        }

        this.buyerName = buyerName.trim();
        this.itemName = itemName.trim();
        this.price = price;
        this.status = TransactionStatus.PENDING; // every deal starts as PENDING
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void updateStatus(TransactionStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return String.format("%s is buying %s for R%.2f [%s]",
                buyerName, itemName, price, status);
    }
}
