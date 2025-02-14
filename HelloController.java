package com.example.hw2311;

import javafx.scene.control.TextField;

public class HelloController {

    private TextField fieldLoanAmount;

    private TextField fieldInterestRate;

    private TextField fieldNumberOfYears;

    private TextField fieldMonthlyPayment;

    private TextField fieldTotalPayment;

    private void computePayment() {
        try {
            double loanAmount = Double.parseDouble(fieldLoanAmount.getText());
            double annualInterestRate = Double.parseDouble(fieldInterestRate.getText());
            int numberOfYears = Integer.parseInt(fieldNumberOfYears.getText());

            double monthlyInterestRate = annualInterestRate / 1200;
            int numberOfMonths = numberOfYears * 12;
            double monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfMonths)));
            double totalPayment = monthlyPayment * numberOfMonths;

            fieldMonthlyPayment.setText(String.format("%.2f", monthlyPayment));
            fieldTotalPayment.setText(String.format("%.2f", totalPayment));
        } catch (NumberFormatException ex) {
            fieldMonthlyPayment.setText("Invalid");
            fieldTotalPayment.setText("Invalid");
        }
    }
}
