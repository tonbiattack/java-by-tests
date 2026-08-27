package examples.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class GenericBoundsTest {
  @Test
  void extendsはIntegerのListをNumberとして読み取れる() {
    assertEquals(3.0, GenericBounds.sum(List.of(1, 2)));
  }

  @Test
  void superはNumberのListへIntegerを追加できる() {
    List<Number> numbers = new ArrayList<>();

    GenericBounds.addDefaults(numbers);

    assertEquals(List.of(1, 2), numbers);
  }
}
