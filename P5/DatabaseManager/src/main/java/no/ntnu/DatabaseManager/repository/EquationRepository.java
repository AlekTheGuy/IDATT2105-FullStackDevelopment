package no.ntnu.DatabaseManager.repository;

import java.util.List;

import no.ntnu.DatabaseManager.model.Equation;

public interface EquationRepository {
    int save(Equation equation);
    List<Equation> findAll();
}
