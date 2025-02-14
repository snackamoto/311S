package com.example.hw2311;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label labelLoanAmount = new Label("Loan $ : ");
        TextField fieldLoanAmount = new TextField();

        Label labelAnnualInterestRate = new Label("Interest % : ");
        TextField fieldAnnualInterestRate = new TextField();

        Label labelNumberOfYears = new Label("Years : ");
        TextField fieldNumberOfYears = new TextField();

        Button btnCompute = new Button("Payment");

        Label labelMonthlyPayment = new Label("Monthly payment : ");
        TextField fieldMonthlyPayment = new TextField();
        fieldMonthlyPayment.setEditable(false);

        Label labelTotalPayment = new Label("Total payment : ");
        TextField fieldTotalPayment = new TextField();
        fieldTotalPayment.setEditable(false);

        // Creating layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Adding components to the layout
        gridPane.add(labelLoanAmount, 0, 0);
        gridPane.add(fieldLoanAmount, 1, 0);
        gridPane.add(labelAnnualInterestRate, 0, 1);
        gridPane.add(fieldAnnualInterestRate, 1, 1);
        gridPane.add(labelNumberOfYears, 0, 2);
        gridPane.add(fieldNumberOfYears, 1, 2);
        gridPane.add(btnCompute, 1, 3);
        gridPane.add(labelMonthlyPayment, 0, 4);
        gridPane.add(fieldMonthlyPayment, 1, 4);
        gridPane.add(labelTotalPayment, 0, 5);
        gridPane.add(fieldTotalPayment, 1, 5);

        btnCompute.setOnAction(e -> {
            try {
                double loanAmount = Double.parseDouble(fieldLoanAmount.getText());
                double annualInterestRate = Double.parseDouble(fieldAnnualInterestRate.getText());
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
        });

        Scene scene = new Scene(gridPane, 500, 500);
        primaryStage.setTitle("Loan Interest Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}