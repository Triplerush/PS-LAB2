package class_test;

import ATMCaseStudy.Keypad;

public class TestKeypad extends Keypad {
    private int input;
    private boolean invalidInput = false;

    @Override
    public int getInput() {
        if (invalidInput) {
            throw new java.util.InputMismatchException();
        }
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setInvalidInput(boolean invalidInput) {
        this.invalidInput = invalidInput;
    }
}