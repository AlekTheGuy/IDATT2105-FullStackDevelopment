package no.ntnu.DatabaseManager.service;

import org.springframework.stereotype.Service;

@Service
public class Calculate {

    public Calculate() {}

    public Double calculate(double num1, double num2, String operator) {
        if (operator.equals("-")) {
            return num1 - num2;
        } else if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("/")) {
            return num1 / num2;
        }
        return num1 + num2;
    }
    
}
