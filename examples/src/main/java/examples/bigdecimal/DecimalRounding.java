package examples.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DecimalRounding {
  private DecimalRounding() {}

  public static BigDecimal divide(
      BigDecimal dividend, BigDecimal divisor, RoundingMode roundingMode) {
    return dividend.divide(divisor, 2, roundingMode);
  }
}
