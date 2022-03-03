package no.ntnu.P4.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Calculator {

    ArrayList<String> calculations;

    public Calculator() {
        calculations = new ArrayList<>();
        calculations.add("0");
    }

    public ArrayList<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(ArrayList<String> calculations) {
        this.calculations = calculations;
    }

    public String calculate(double num1, double num2, String operator) {
        if (operator.equals("-")) {
            return num1 + " - " + num2 + " = " + (num1 - num2);
        } else if (operator.equals("*")) {
            return num1 + " * " + num2 + " = " + (num1 * num2);
        } else if (operator.equals("/")) {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
}
