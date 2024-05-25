package tests_ATM;

import org.junit.Before;
import org.junit.Test;
import ATMCaseStudy.Withdrawal;
import class_test.TestBankDatabase;
import class_test.TestCashDispenser;
import class_test.TestKeypad;
import class_test.TestScreen;
import static org.junit.Assert.*;

public class WithdrawalTest {
	private TestScreen screen;
	private TestBankDatabase bankDatabase;
	private TestKeypad keypad;
	private TestCashDispenser cashDispenser;
	private Withdrawal withdrawal;

	// Configuración antes de cada prueba
	@Before
	public void setUp() {
		screen = new TestScreen();
		bankDatabase = new TestBankDatabase();
		keypad = new TestKeypad();
		cashDispenser = new TestCashDispenser();
		withdrawal = new Withdrawal(12345, screen, bankDatabase, keypad, cashDispenser);
	}

	// Prueba un retiro exitoso
	@Test
	public void testExecuteWithdrawalSuccess() {
		bankDatabase.setBalance(12345, 1000.0);
		keypad.setInput(1);
		cashDispenser.setSufficientCashAvailable(true);
		withdrawal.execute();
		assertEquals("\nWithdrawal menu:\n" + "1 - $20\n" + "2 - $40\n" + "3 - $60\n" + "4 - $100\n" + "5 - $200\n"
				+ "6 - Cancel transaction\n\n" + "Choose a withdrawal amount: "
				+ "\nYour cash has been dispensed. Please take your cash now.\n", screen.getMessages());
		assertEquals(980.0, bankDatabase.getBalance(12345), 0.01);
	}

	// Prueba un retiro con fondos insuficientes
	@Test
	public void testExecuteWithdrawalInsufficientFunds() {
		bankDatabase.setBalance(12345, 10.0);
		keypad.setInput(1);
		withdrawal.execute();
		assertEquals(
				"\nWithdrawal menu:\n" + "1 - $20\n" + "2 - $40\n" + "3 - $60\n" + "4 - $100\n" + "5 - $200\n"
						+ "6 - Cancel transaction\n\n" + "Choose a withdrawal amount: \n"
						+ "Insufficient cash available in the ATM.\n\nPlease choose a smaller amount.\n",
				screen.getMessages());
		assertEquals(10.0, bankDatabase.getBalance(12345), 0.01);
	}

	// Prueba una transacción de retiro cancelada
	@Test
	public void testExecuteWithdrawalCancelled() {
		keypad.setInput(6);
		withdrawal.execute();
		assertEquals("\nWithdrawal menu:\n" + "1 - $20\n" + "2 - $40\n" + "3 - $60\n" + "4 - $100\n" + "5 - $200\n"
				+ "6 - Cancel transaction\n\n" + "Choose a withdrawal amount: " + "\nCanceling transaction...\n",
				screen.getMessages());
	}

	// Prueba una entrada inválida durante el retiro
	@Test
	public void testExecuteWithdrawalInvalidInput() {
		keypad.setInvalidInput(true); // Simulate invalid input
		withdrawal.execute();
		assertEquals("\nWithdrawal menu:\n" + "1 - $20\n" + "2 - $40\n" + "3 - $60\n" + "4 - $100\n" + "5 - $200\n"
				+ "6 - Cancel transaction\n\n" + "Choose a withdrawal amount: " + "\nInvalid input. Canceling transaction...\n",
				screen.getMessages());
		assertEquals(0.0, bankDatabase.getBalance(12345), 0.01);
	}
}
