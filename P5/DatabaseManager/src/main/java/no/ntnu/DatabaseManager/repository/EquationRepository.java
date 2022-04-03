package no.ntnu.DatabaseManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import no.ntnu.DatabaseManager.entity.Equation;

public interface EquationRepository extends JpaRepository<Equation, Long> {
}