package class_test;

import ATMCaseStudy.DepositSlot;

public class TestDepositSlot extends DepositSlot {
    private boolean envelopeReceived;

    @Override
    public boolean isEnvelopeReceived() {
        return envelopeReceived;
    }

    public void setEnvelopeReceived(boolean envelopeReceived) {
        this.envelopeReceived = envelopeReceived;
    }
}
