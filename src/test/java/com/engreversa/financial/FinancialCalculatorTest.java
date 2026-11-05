package com.engreversa.financial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FinancialCalculatorTest {
    private static final double DELTA = 0.000001;
    private final FinancialCalculator calculator = new FinancialCalculator();

    @Test
    public void whenConv_withStatus_thenCorrect() {
        double[] values = {200.0, 100.0};
        Client client = new Client(ClientType.CONVENTION.getIdentifier(), true);
        assertEquals(279.50, calculator.calculate(values, client), DELTA);
    }

    @Test
    public void whenConv_withoutStatus_thenCorrect() {
        double[] values = {200.0, 100.0};
        Client client = new Client(ClientType.CONVENTION.getIdentifier(), false);
        assertEquals(264.00, calculator.calculate(values, client), DELTA);
    }

    @Test
    public void whenPart_over500_thenCorrect() {
        double[] values = {500.0, 500.0};
        Client client = new Client(ClientType.PARTICULAR.getIdentifier(), false);
        assertEquals(950.00, calculator.calculate(values, client), DELTA);
    }

    @Test
    public void whenPart_exact500_thenNoDiscount() {
        double[] values = {250.0, 250.0};
        Client client = new Client(ClientType.PARTICULAR.getIdentifier(), false);
        assertEquals(500.00, calculator.calculate(values, client), DELTA);
    }

    @Test
    public void whenUnrecognizedType_thenCorrect() {
        double[] values = {100.0, 100.0};
        Client client = new Client(5, false); // Type not recognized
        assertEquals(200.00, calculator.calculate(values, client), DELTA);
    }
}
