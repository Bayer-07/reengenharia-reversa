package com.engreversa.financial;

import java.util.Arrays;
import java.util.Optional;

public enum ClientType {
    CONVENTION(1) {
        @Override
        public double applyRules(double total, Client client) {
            double result = total - (total * CONVENTION_DISCOUNT_RATE);
            if (client.isStatusPartial()) {
                result += CONVENTION_PARTIAL_FEE;
            }
            return result;
        }
    },
    PARTICULAR(2) {
        @Override
        public double applyRules(double total, Client client) {
            if (total > PARTICULAR_DISCOUNT_THRESHOLD) {
                return total - (total * PARTICULAR_DISCOUNT_RATE);
            }
            return total;
        }
    };

    private static final double CONVENTION_DISCOUNT_RATE = 0.12;
    private static final double CONVENTION_PARTIAL_FEE = 15.50;
    private static final double PARTICULAR_DISCOUNT_RATE = 0.05;
    private static final double PARTICULAR_DISCOUNT_THRESHOLD = 500.0;

    private final int identifier;

    ClientType(int identifier) {
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return identifier;
    }

    public abstract double applyRules(double total, Client client);

    public static Optional<ClientType> fromIdentifier(int identifier) {
        return Arrays.stream(values())
                .filter(type -> type.identifier == identifier)
                .findFirst();
    }
}
