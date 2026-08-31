package examples.collector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class DuplicateKeysTest {
  @Test
  void toMapは同じキーがあるとmerge関数なしでは例外にする() {
    assertThrows(
        IllegalStateException.class, () -> DuplicateKeys.withoutMerge(List.of("Java", "JAVA")));
  }

  @Test
  void merge関数を指定すると重複キーの扱いを明示できる() {
    assertEquals(4, DuplicateKeys.keepingLast(List.of("Java", "JAVA")).get("java"));
  }
}
