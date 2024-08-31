package org.example;

public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        int n = 3;
        int factorial = calculator.findFactorial(n);
        System.out.println("Факториал числа " + n + " равен " + factorial + ".");
    }
}