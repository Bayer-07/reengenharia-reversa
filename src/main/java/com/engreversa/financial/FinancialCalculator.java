package com.engreversa.financial;

public class FinancialCalculator {
    public double calculate(double[] values, Client client) {
        double total = 0.0;
        for (double value : values) {
            total += value;
        }

        final double subtotal = total;
        return ClientType.fromIdentifier(client.getType())
                .map(type -> type.applyRules(subtotal, client))
                .orElse(subtotal);
    }
}
