package org.example;

public class FactorialCalculator {
    public int findFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * findFactorial(n - 1);
        }
    }
}