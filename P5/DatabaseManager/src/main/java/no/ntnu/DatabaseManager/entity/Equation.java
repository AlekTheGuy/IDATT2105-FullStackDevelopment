package no.ntnu.DatabaseManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equation {
    
    private @Id @GeneratedValue Long id;
    private int num1;
    private int num2;
    private char operator;

    public Equation() {
    }

    public Equation(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return this.num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public char getOperator() {
        return this.operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", num1='" + getNum1() + "'" +
            ", num2='" + getNum2() + "'" +
            ", operator='" + getOperator() + "'" +
            "}";
    }
}
