package examples.bigdecimal;

import java.math.BigDecimal;

public final class BigDecimalComparison {
  private BigDecimalComparison() {}

  public static boolean equalsValueAndScale(BigDecimal left, BigDecimal right) {
    return left.equals(right);
  }

  public static boolean hasSameNumericValue(BigDecimal left, BigDecimal right) {
    return left.compareTo(right) == 0;
  }
}
