package securedeal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Performance test (a non-functional test: it checks HOW FAST the code is,
 * not just whether it gives the right answer).
 */
class PerformanceTest {

    private static final int HOW_MANY = 10_000;
    private static final long MAX_MILLISECONDS = 1_000;

    @Test
    void creatingTenThousandTransactions_isFastEnough() {
        long start = System.nanoTime();

        int created = 0;
        for (int i = 0; i < HOW_MANY; i++) {
            Transaction t = new Transaction("Buyer" + i, "Item" + i, 10.00 + i);
            t.updateStatus(TransactionStatus.SHIPPED);
            created++;
        }

        long millisecondsTaken = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Created " + created + " transactions in " + millisecondsTaken + " ms");

        assertEquals(HOW_MANY, created);
        assertTrue(millisecondsTaken < MAX_MILLISECONDS,
                "Took " + millisecondsTaken + " ms, expected under " + MAX_MILLISECONDS + " ms");
    }
}
