package no.ntnu.DatabaseManager.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.DatabaseManager.entity.Equation;
import no.ntnu.DatabaseManager.repository.EquationRepository;
import no.ntnu.DatabaseManager.service.Calculate;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class EquationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EquationRepository repository;
    @Autowired
    Calculate calculate;

    @GetMapping("/equations")
    String getAllEquations(@RequestParam Optional<Integer> page, @RequestParam Integer amount) {
        logger.info("Getting the: " + amount + " previous calculations");

        StringBuilder stringBuilder = new StringBuilder();
        List<Equation> equations = repository.findAll(
            PageRequest.of(page.orElse(0), amount, Sort.by("id").descending())
        ).getContent();

        for (Equation equation : equations) {
            stringBuilder.append(equation.toString() + "\n");
        }

        logger.info("Returning previous calculations");
        return stringBuilder.toString();
    }

    @PostMapping("/equations")
    Equation addNewEquation(@RequestBody Equation newEquation) {
        logger.info("adding new calculation");
        newEquation.setAnswer(calculate.calculate(newEquation.getNum1(), newEquation.getNum2(), String.valueOf(newEquation.getOperator())));
        return repository.save(newEquation);
    }

}
