package examples.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class OptionalMappingTest {
  @Test
  void mapはOptionalを返す関数に対してOptionalを二重にする() {
    assertEquals(
        Optional.of(Optional.of("member")), OptionalMapping.withMap(Optional.of("member")));
  }

  @Test
  void flatMapはOptionalを返す関数の結果を平坦化する() {
    assertEquals(Optional.of("member"), OptionalMapping.withFlatMap(Optional.of("member")));
  }
}
