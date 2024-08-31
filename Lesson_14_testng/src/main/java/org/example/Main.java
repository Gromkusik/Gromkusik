package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        int n = 3;
        int factorial = calculator.findFactorial(n);
        System.out.println("Факториал числа " + n + " равен " + factorial + ".");
    }
}