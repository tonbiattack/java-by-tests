package examples.bigdecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

class DecimalRoundingTest {
  @Test
  void BigDecimalの除算は指定した丸めモードで結果が変わる() {
    var one = new BigDecimal("1");
    var three = new BigDecimal("3");

    assertEquals(new BigDecimal("0.33"), DecimalRounding.divide(one, three, RoundingMode.DOWN));
    assertEquals(new BigDecimal("0.34"), DecimalRounding.divide(one, three, RoundingMode.UP));
  }
}
