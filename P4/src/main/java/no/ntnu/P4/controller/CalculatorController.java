package no.ntnu.P4.controller;

import no.ntnu.P4.model.Equation;
import no.ntnu.P4.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CalculatorController {
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    Calculator calculator;

    @GetMapping("/calculate")
    public String getEquationAnswer() {
        logger.info("Last answer returned");
        return calculator.getCalculations().get(calculator.getCalculations().size() - 1);
    }

    @PostMapping("/calculate")
    public Equation postEquation(@RequestBody Equation equation) {
        try {
            String sum = calculator.calculate(equation.getNum1(), equation.getNum2(), equation.getOperator());
            calculator.getCalculations().add(sum);
            logger.info("Calculation added");
        } catch (Exception e) {
            logger.warn("Error: " + e.getMessage());
        }
        return equation;
    }
}
