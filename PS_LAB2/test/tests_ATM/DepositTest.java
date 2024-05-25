package tests_ATM;

import org.junit.Before;
import org.junit.Test;
import ATMCaseStudy.Deposit;
import class_test.TestBankDatabase;
import class_test.TestDepositSlot;
import class_test.TestKeypad;
import class_test.TestScreen;
import static org.junit.Assert.*;

public class DepositTest {
	private TestScreen screen;
	private TestBankDatabase bankDatabase;
	private TestKeypad keypad;
	private TestDepositSlot depositSlot;
	private Deposit deposit;

	// Este método se ejecuta antes de cada prueba unitaria
	@Before
	public void setUp() {
		screen = new TestScreen();
		bankDatabase = new TestBankDatabase();
		keypad = new TestKeypad();
		depositSlot = new TestDepositSlot();
		deposit = new Deposit(12345, screen, bankDatabase, keypad, depositSlot);
	}

	// Prueba un depósito exitoso
	@Test
	public void testExecuteDepositSuccess() {
		keypad.setInput(100);
		depositSlot.setEnvelopeReceived(true);
		deposit.execute();
		assertEquals(1.0, bankDatabase.getBalance(12345), 5);
		assertEquals("\nPlease enter a deposit amount in CENTS (or 0 to cancel): "
				+ "\nPlease insert a deposit envelope containing ." + "\n\nYour envelope has beenreceived."
				+ "\nNOTE: The money just deposited will not be available until we verify "
				+ "the amount of any enclosed cash and your checks clear.", screen.getMessages());
	}

	// Prueba un depósito cancelado
	@Test
	public void testExecuteDepositCancelled() {
		keypad.setInput(0); // Simulate input of 0 cents (cancellation)
		deposit.execute();
		assertEquals("\nPlease enter a deposit amount in CENTS (or 0 to cancel): " + "\nCanceling transaction...\n",
				screen.getMessages());
	}

	// Prueba una entrada inválida durante el depósito
	@Test
	public void testExecuteDepositInvalidInput() {
		keypad.setInvalidInput(true);
		deposit.execute();
		assertEquals("\nPlease enter a deposit amount in CENTS (or 0 to cancel): " + "\nInvalid input. Canceling transaction...\n",
				screen.getMessages());
	}
}
