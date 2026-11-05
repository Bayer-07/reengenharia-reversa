package com.engreversa.financial;

public class FinancialCalculator {
    public double calculate(double[] values, Client client) {
        double total = 0.0;
        for (double value : values) {
            total += value;
        }

        if (client.getType() == ClientType.CONVENTION.getIdentifier()) {
            double discount = total * 0.12;
            total -= discount;
            if (client.isStatusPartial()) {
                total += ClientType.CONVENTION.getAdditionalAmount();
            }
        } else if (client.getType() == ClientType.PARTICULAR.getIdentifier()) {
            if (total > 500) {
                double discount = total * 0.05;
                total -= discount;
            }
        }

        return total;
    }
}
