package no.ntnu.P4.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Calculator {

    ArrayList<String> calculations = new ArrayList<>();

    public Calculator() {
    }

    public ArrayList<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(ArrayList<String> calculations) {
        this.calculations = calculations;
    }

    public String calculate(double num1, double num2, char operator) {
        if (operator == '-') {
            return num1 + " - " + num2 + " = " + (num1 - num2);
        } else if (operator == '*') {
            return num1 + " * " + num2 + " = " + (num1 * num2);
        } else if (operator == '/') {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
}
