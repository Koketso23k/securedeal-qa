package securedeal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    // ---------- Creating a transaction ----------

    @Test
    void validDetails_createsTransaction() {
        Transaction t = new Transaction("Thabo", "Laptop", 4500.00);

        assertEquals("Thabo", t.getBuyerName());
        assertEquals("Laptop", t.getItemName());
        assertEquals(4500.00, t.getPrice());
    }

    @Test
    void newTransaction_startsAsPending() {
        Transaction t = new Transaction("Thabo", "Laptop", 4500.00);

        assertEquals(TransactionStatus.PENDING, t.getStatus());
    }

    // ---------- Rejecting bad input ----------

    @Test
    void emptyItemName_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Thabo", "", 100.00));
    }

    @Test
    void blankItemName_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Thabo", "   ", 100.00));
    }

    @Test
    void nullItemName_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Thabo", null, 100.00));
    }

    @Test
    void emptyBuyerName_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("", "Laptop", 100.00));
    }

    @Test
    void negativePrice_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Thabo", "Laptop", -50.00));
    }

    @Test
    void zeroPrice_isRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Thabo", "Laptop", 0));
    }

    // ---------- Changing the status ----------

    @Test
    void statusChangesToShipped() {
        Transaction t = new Transaction("Thabo", "Laptop", 4500.00);

        t.updateStatus(TransactionStatus.SHIPPED);

        assertEquals(TransactionStatus.SHIPPED, t.getStatus());
    }

    @Test
    void statusChangesToReceived() {
        Transaction t = new Transaction("Thabo", "Laptop", 4500.00);

        t.updateStatus(TransactionStatus.RECEIVED);

        assertEquals(TransactionStatus.RECEIVED, t.getStatus());
    }

    @Test
    void emptyStatus_isRejected() {
        Transaction t = new Transaction("Thabo", "Laptop", 4500.00);

        assertThrows(IllegalArgumentException.class, () -> t.updateStatus(null));
    }
}
