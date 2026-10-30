package securedeal;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the text menu (Main) by typing the answers for it
 * and reading what it prints.
 */
class MainTest {

    // Runs Main with the given typed answers and returns everything it printed.
    private String runMenu(String typedAnswers) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream printed = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(typedAnswers.getBytes()));
            System.setOut(new PrintStream(printed));
            Main.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        return printed.toString();
    }

    @Test
    void validDetails_createsThenUpdatesStatus() {
        String output = runMenu("Thabo\nLaptop\n4500\nSHIPPED\n");

        assertTrue(output.contains("Created: Thabo is buying Laptop"));
        assertTrue(output.contains("[PENDING]"));
        assertTrue(output.contains("[SHIPPED]"));
    }

    @Test
    void emptyItemName_showsError() {
        String output = runMenu("Thabo\n\n100\n");

        assertTrue(output.contains("Error: Item name cannot be empty"));
    }

    @Test
    void negativePrice_showsError() {
        String output = runMenu("Thabo\nLaptop\n-50\n");

        assertTrue(output.contains("Error: Price must be more than zero"));
    }

    @Test
    void priceThatIsNotANumber_showsError() {
        String output = runMenu("Thabo\nLaptop\nabc\n");

        assertTrue(output.contains("Error: price must be a number"));
    }

    @Test
    void unknownStatus_showsAnError() {
        // This is BUG-1: the message is correct to reject it, but not friendly.
        String output = runMenu("Thabo\nLaptop\n100\nLOST\n");

        assertTrue(output.contains("Error:"));
    }
}