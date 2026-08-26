package examples.generics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTotalsTest {
    @Test
    void IntegerのListをNumberとして合計できる() { assertEquals(6.0, NumberTotals.sum(List.of(1, 2, 3))); }

    @Test
    void DoubleのListも同じメソッドで合計できる() { assertEquals(3.5, NumberTotals.sum(List.of(1.0, 2.5))); }
}
