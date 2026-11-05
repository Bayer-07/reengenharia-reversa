package com.engreversa.financial;

public class Main {
    public static void main(String[] args) {
        FinancialCalculator calculator = new FinancialCalculator();

        double[] values1 = {200.0, 100.0};
        Client client1 = new Client(ClientType.CONVENTION.getIdentifier(), true);
        System.out.printf("%.2f%n", calculator.calculate(values1, client1)); // Expected output: 279.50

        double[] values2 = {200.0, 100.0};
        Client client2 = new Client(ClientType.CONVENTION.getIdentifier(), false);
        System.out.printf("%.2f%n", calculator.calculate(values2, client2)); // Expected output: 264.00

        double[] values3 = {500.0, 500.0};
        Client client3 = new Client(ClientType.PARTICULAR.getIdentifier(), false);
        System.out.printf("%.2f%n", calculator.calculate(values3, client3)); // Expected output: 950.00

        double[] values4 = {250.0, 250.0};
        Client client4 = new Client(ClientType.PARTICULAR.getIdentifier(), false);
        System.out.printf("%.2f%n", calculator.calculate(values4, client4)); // Expected output: 500.00

        double[] values5 = {100.0, 100.0};
        Client client5 = new Client(5, false); // Type not recognized
        System.out.printf("%.2f%n", calculator.calculate(values5, client5)); // Expected output: 200.00
    }
}
