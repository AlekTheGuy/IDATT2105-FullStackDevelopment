package no.ntnu.DatabaseManager.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import no.ntnu.DatabaseManager.model.Equation;

@Repository
public class JdbcEquationRepository implements EquationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Equation equation) {
        return jdbcTemplate.update("INSERT INTO EQUATIONS (num1, num2, operator, answer) VALUES (?, ?, ?, ?)",
                new Object[] { equation.getNum1(), equation.getNum2(), equation.getOperator(), 2 });
    }

    @Override
    public List<Equation> findAll() {
        return jdbcTemplate.query("SELECT * from equations", BeanPropertyRowMapper.newInstance(Equation.class));
    }
}
