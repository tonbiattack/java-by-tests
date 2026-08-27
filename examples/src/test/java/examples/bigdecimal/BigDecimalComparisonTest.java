package examples.bigdecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BigDecimalComparisonTest {
  @Test
  void scaleが異なるBigDecimalはequalsで等しくない() {
    assertFalse(
        BigDecimalComparison.equalsValueAndScale(new BigDecimal("1.0"), new BigDecimal("1.00")));
  }

  @Test
  void scaleが異なっても数値として同じBigDecimalはcompareToで等しい() {
    assertTrue(
        BigDecimalComparison.hasSameNumericValue(new BigDecimal("1.0"), new BigDecimal("1.00")));
  }
}
