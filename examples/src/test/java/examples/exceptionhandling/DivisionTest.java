package examples.exceptionhandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionTest {
    @Test
    void 割り切れる数なら整数の商を返す() { assertEquals(5, Division.divide(10, 2)); }

    @Test
    void ゼロで割るとArithmeticExceptionが送出される() {
        assertThrows(ArithmeticException.class, () -> Division.divide(10, 0));
    }
}
