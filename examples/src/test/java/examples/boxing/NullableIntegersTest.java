package examples.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NullableIntegersTest {
  @Test
  void nullのIntegerを計算するとunboxing時にNullPointerExceptionになる() {
    assertThrows(NullPointerException.class, () -> NullableIntegers.increment(null));
  }

  @Test
  void 値があるIntegerはunboxingして計算できる() {
    assertEquals(2, NullableIntegers.increment(1));
  }
}
