import org.example.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCalculateFactorial {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();

        Assert.assertEquals(calculator.findFactorial(0), 1);
        Assert.assertEquals(calculator.findFactorial(1), 1);
        Assert.assertEquals(calculator.findFactorial(3), 6);
        Assert.assertEquals(calculator.findFactorial(12), 479001600);
    }
}