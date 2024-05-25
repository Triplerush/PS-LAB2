package tests_ATM;

import static org.junit.Assert.*;
import org.junit.Test;
import ATMCaseStudy.BankDatabase;
import org.junit.Before;

public class AuxiliarClassesTest {
    private BankDatabase bankDatabase;

    // Se ejecuta antes de cada prueba
    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    // Prueba la autenticación de un usuario
    @Test
    public void testAuthenticateUser() {
        assertTrue(bankDatabase.authenticateUser(12345, 54321));
        assertFalse(bankDatabase.authenticateUser(12345, 12345));
    }

    // Prueba la obtención del saldo disponible
    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    // Prueba el crédito en una cuenta
    @Test
    public void testCredit() {
        bankDatabase.credit(12345, 100.0);
        assertEquals(1100.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    // Prueba el débito en una cuenta
    @Test
    public void testDebit() {
        bankDatabase.debit(12345, 100.0);
        assertEquals(900.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    // Prueba la autenticación de un usuario inválido
    @Test
    public void testAuthenticateInvalidUser() {
        assertFalse(bankDatabase.authenticateUser(99999, 54321));
    }

    // Prueba el crédito en una cuenta inválida
    @Test
    public void testCreditInvalidAccount() {
        bankDatabase.credit(99999, 100.0);
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    // Prueba el débito en una cuenta inválida
    @Test
    public void testDebitInvalidAccount() {
        bankDatabase.debit(99999, 100.0);
        assertEquals(1000.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }

    // Prueba el débito con fondos insuficientes
    @Test
    public void testDebitInsufficientFunds() {
        bankDatabase.debit(12345, 1100.0);
        assertEquals(0.0, bankDatabase.getAvailableBalance(12345), 0.01);
    }
}

