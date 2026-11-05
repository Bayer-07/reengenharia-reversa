package com.engreversa.financial;

public enum ClientType {
    CONVENTION(1, 15.50),
    PARTICULAR(2, 0.0);

    private final int identifier;
    private final double additionalAmount;

    ClientType(int identifier, double additionalAmount) {
        this.identifier = identifier;
        this.additionalAmount = additionalAmount;
    }

    public int getIdentifier() {
        return identifier;
    }

    public double getAdditionalAmount() {
        return additionalAmount;
    }
}
