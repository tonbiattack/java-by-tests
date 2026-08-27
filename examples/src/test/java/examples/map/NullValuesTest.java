package examples.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NullValuesTest {
  @Test
  void getだけではnull値のキーと未登録キーを区別できない() {
    var values = NullValues.withNullValue();

    assertNull(values.get("configured"));
    assertNull(values.get("missing"));
    assertTrue(values.containsKey("configured"));
    assertFalse(values.containsKey("missing"));
  }
}
