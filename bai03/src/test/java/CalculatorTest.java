import bai.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    static Calculator casioFx580;
    @BeforeAll
    static void createCalculator(){
        casioFx580=new Calculator();
    }
    @Test
    void testAdd(){
        double result=casioFx580.plus(10,0);
        assertEquals(10, result);
    }

    @Test
    void testPlus(){
        double result=casioFx580.divide(10,1);
        assertEquals(11, result);
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> {
            casioFx580.divide(10, 0);
        });
    }
}
