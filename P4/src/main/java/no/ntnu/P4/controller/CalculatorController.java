package no.ntnu.P4.controller;

import no.ntnu.P4.model.Equation;
import no.ntnu.P4.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class CalculatorController {

    @Autowired
    Calculator calculator;

    @GetMapping("/calculate")
    public String getEquationAnswer() {
        return calculator.getCalculations().get(calculator.getCalculations().size() - 1);
    }

    @GetMapping("/calculate/all")
    public ArrayList<String> getCalculations() {
        return calculator.getCalculations();
    }

    @PostMapping("/calculate")
    public Equation postEquation(@RequestBody Equation equation) {
        String sum = calculator.calculate(equation.getNum1(), equation.getNum2(), equation.getOperator());
        calculator.getCalculations().add(sum);
        return equation;
    }
}
