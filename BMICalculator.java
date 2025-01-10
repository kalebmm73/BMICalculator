package com.example.hw10;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BMICalculator extends Application {
      static TextField tfName = new TextField();
      static TextField tfAge = new TextField();
      static TextField tfHeight = new TextField();
      static TextField tfWeight = new TextField();
      static TextField tfBMI = new TextField();
      static TextField tfStatus = new TextField();
      static Button btCalculate = new Button("Calculate");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("Name: "), 0, 0);
        gridPane.add(tfName, 1, 0);
        gridPane.add(new Label("Age: "), 0, 1);
        gridPane.add(tfAge, 1, 1);
        gridPane.add(new Label("Height: "), 0, 2);
        gridPane.add(tfHeight, 1, 2);
        gridPane.add(new Label("Weight: "), 0, 3);
        gridPane.add(tfWeight, 1, 3);
        gridPane.add(new Label("BMI: "), 0, 4);
        gridPane.add(tfBMI, 1, 4);
        gridPane.add(new Label("Status: "), 0, 5);
        gridPane.add(tfStatus, 1, 5);
        gridPane.add(btCalculate, 1, 6);

        gridPane.setAlignment(Pos.CENTER);
        tfName.setAlignment(Pos.BOTTOM_RIGHT);
        tfAge.setAlignment(Pos.BOTTOM_RIGHT);
        tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
        tfWeight.setAlignment(Pos.BOTTOM_RIGHT);
        tfBMI.setAlignment(Pos.BOTTOM_RIGHT);
        tfStatus.setAlignment(Pos.BOTTOM_RIGHT);
        tfBMI.setEditable(false);
        tfStatus.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        btCalculate.setOnAction(
                e -> {
                    calculateBMI();
                    System.out.println("Hi " + BMICalculator.tfName.getText() + "!");
                    System.out.println("You are " + BMICalculator.tfAge.getText() + " years old");
                    System.out.println("You are " + BMICalculator.tfHeight.getText() + " inches tall");
                    System.out.println("You weigh " + BMICalculator.tfWeight.getText() + " pounds");
                });

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI() {
        String name = tfName.getText();
        int age = Integer.parseInt(tfAge.getText());
        double height = Double.parseDouble(tfHeight.getText());
        double weight = Double.parseDouble(tfWeight.getText());

        BMI bmi = new BMI(name, age, weight, height);

        tfBMI.setText(String.format("%.2f", bmi.getBMI()));
        tfStatus.setText(String.format(bmi.getStatus()));
    }
}