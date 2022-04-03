package no.ntnu.DatabaseManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
public class EquationController {

    @Autowired
    EquationRepository repository;
    @Autowired
    Calculate calculate;

    @GetMapping("/equations")
    ArrayList<String> getAllEquations(@RequestParam Optional<Integer> page, @RequestParam Integer amount) {
        ArrayList<String> tempArrayList = new ArrayList<>();
        List<Equation> equations = repository.findAll(
            PageRequest.of(page.orElse(0), amount, Sort.by("id").descending())
        ).getContent();

        for (Equation equation : equations) {
            tempArrayList.add(equation.toString());
        }

        return tempArrayList;
    }

    @PostMapping("/equations")
    Equation addNewEquation(@RequestBody Equation newEquation) {
        newEquation.setAnswer(calculate.calculate(newEquation.getNum1(), newEquation.getNum2(), String.valueOf(newEquation.getOperator())));
        return repository.save(newEquation);
    }

}
