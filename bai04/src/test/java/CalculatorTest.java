import bai.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

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
    void testDivide(){
        double result=casioFx580.divide(10,1);
        assertEquals(10, result);
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> {
            casioFx580.divide(10, 0);
        });
    }

    @Test
    void testHardcoreD(){
        String path= "C:\\Users\\Admin\\Desktop\\Week9\\in.txt";
        File file =new File(path);
        assertTrue(file.exists());
    }
}
