import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTestingWithConner {

    @Test
    public void testNullInput() {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = new FizzBuzz();
            String actual = fizzBuzz.fizzBuzz(null);

        });
        assertEquals("Fizzbuzz can't take null", t.getMessage()); // the message of the exception is what I want.


    }
}
class FizzBuzz {
    public String fizzBuzz(String input) {
        if(input == null) {
            return null;
        }
        if(input.startsWith("b")) {
            return "buzz";
        }
        else if(input.endsWith("f")) {
            return "fizz";
        }
        else {
            return "fizzbuzz";
        }
    }
}