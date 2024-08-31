import org.example.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testFactorialCalculator {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();

        Assertions.assertEquals(1, calculator.findFactorial(0));
        Assertions.assertEquals(1, calculator.findFactorial(1));
        Assertions.assertEquals(6, calculator.findFactorial(3));
        Assertions.assertEquals(479001600, calculator.findFactorial(12));
    }
}