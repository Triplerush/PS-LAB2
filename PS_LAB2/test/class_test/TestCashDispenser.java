package class_test;

import ATMCaseStudy.CashDispenser;

public class TestCashDispenser extends CashDispenser {
    private boolean sufficientCashAvailable;

    @Override
    public boolean isSufficientCashAvailable(int amount) {
        return sufficientCashAvailable;
    }

    @Override
    public void dispenseCash(int amount) {
        // Simulate dispensing cash
    }

    public void setSufficientCashAvailable(boolean sufficientCashAvailable) {
        this.sufficientCashAvailable = sufficientCashAvailable;
    }
}
