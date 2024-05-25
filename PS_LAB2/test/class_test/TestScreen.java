package class_test;

import ATMCaseStudy.Screen;

// Test helper classes
public class TestScreen extends Screen {
    private StringBuilder messages = new StringBuilder();

    @Override
    public void displayMessage(String message) {
        messages.append(message);
    }

    @Override
    public void displayMessageLine(String message) {
        messages.append(message).append("\n");
    }

    public String getMessages() {
        return messages.toString();
    }
}
