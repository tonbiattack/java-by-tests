package examples.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class OptionalFallbacksTest {
  @Test
  void orElseはOptionalに値があっても引数を評価する() {
    var fallbackCalls = new AtomicInteger();

    var result = OptionalFallbacks.withOrElse(Optional.of("member"), fallbackCalls);

    assertEquals("member", result);
    assertEquals(1, fallbackCalls.get());
  }

  @Test
  void orElseGetはOptionalに値がある場合Supplierを評価しない() {
    var fallbackCalls = new AtomicInteger();

    var result = OptionalFallbacks.withOrElseGet(Optional.of("member"), fallbackCalls);

    assertEquals("member", result);
    assertEquals(0, fallbackCalls.get());
  }
}
