package examples.bigdecimal;

import java.math.BigDecimal;

public final class BigDecimalConstruction {
  private BigDecimalConstruction() {}

  public static BigDecimal fromBinaryDouble(double value) {
    return new BigDecimal(value);
  }

  public static BigDecimal fromDecimalLiteral(String value) {
    return new BigDecimal(value);
  }
}
