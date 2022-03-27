package no.ntnu.DatabaseManager.model;

public class Equation {
    private double num1;
    private double num2;
    private String operator;
    private double answer;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getAnswer() {
        return answer;
    }
    
    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operator=" + operator +
                '}';
    }
}
