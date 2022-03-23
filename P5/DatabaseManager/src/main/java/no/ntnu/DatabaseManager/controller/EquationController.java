package no.ntnu.DatabaseManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.DatabaseManager.model.Equation;
import no.ntnu.DatabaseManager.repository.EquationRepository;

@RestController
@CrossOrigin
public class EquationController {
    @Autowired
    EquationRepository equationRepository;

    @GetMapping("/equations")
    public ResponseEntity<List<Equation>> getAll() {
        List<Equation> equations = new ArrayList<>();
        try {
            equations = equationRepository.findAll();

            // equationRepository.findAll().forEach(equations::add);
        } catch (Exception e) {
            return new ResponseEntity<>(equations, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        for (Equation equation : equations) {
            System.out.println(equation.getNum1());
        }
        return new ResponseEntity<>(equations, HttpStatus.OK);
    }

    @PostMapping("/calculation")
    public ResponseEntity<String> createEquation(@RequestBody Equation equation) {
        try {
            equationRepository.save(equation);
            return new ResponseEntity<>("Equation was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}