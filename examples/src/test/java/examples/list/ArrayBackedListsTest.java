package examples.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ArrayBackedListsTest {
  @Test
  void ArraysAsListで変更した要素は元の配列にも反映される() {
    var values = new String[] {"A", "B"};
    var list = ArrayBackedLists.from(values);

    list.set(0, "X");

    assertEquals("X", values[0]);
  }

  @Test
  void ArraysAsListが返すListには要素を追加できない() {
    List<String> list = ArrayBackedLists.from(new String[] {"A"});

    assertThrows(UnsupportedOperationException.class, () -> list.add("B"));
  }
}
