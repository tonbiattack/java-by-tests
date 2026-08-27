package examples.bigdecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BigDecimalConstructionTest {
  @Test
  void doubleから作るBigDecimalは10進数の0point1と厳密には一致しない() {
    var fromDouble = BigDecimalConstruction.fromBinaryDouble(0.1d);

    assertNotEquals(new BigDecimal("0.1"), fromDouble);
    assertEquals(
        "0.1000000000000000055511151231257827021181583404541015625", fromDouble.toPlainString());
  }

  @Test
  void 文字列から作るBigDecimalは意図した10進数を保持する() {
    assertEquals(new BigDecimal("0.1"), BigDecimalConstruction.fromDecimalLiteral("0.1"));
  }
}
