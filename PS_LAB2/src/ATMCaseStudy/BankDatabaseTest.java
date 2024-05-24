package ATMCaseStudy;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankDatabaseTest {
    private BankDatabase bankDatabase;

    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertFalse(bankDatabase.authenticateUser(12345, 12345));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, 100.0);
        assertEquals(1100.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(12345, 100.0);
        assertEquals(900.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }
}
