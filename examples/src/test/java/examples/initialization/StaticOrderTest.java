package examples.initialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class StaticOrderTest {
  @Test
  void staticFieldは宣言順に初期化される() {
    assertEquals("second", StaticOrder.second());
    assertEquals(List.of("first", "second"), StaticOrder.events());
  }
}
