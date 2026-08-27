package examples.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableStreamListsTest {
  @Test
  void StreamToListは入力と同じ内容のListを返す() {
    assertEquals(List.of("A", "B"), ImmutableStreamLists.copyOf(List.of("A", "B")));
  }

  @Test
  void StreamToListが返すListには要素を追加できない() {
    var list = ImmutableStreamLists.copyOf(List.of("A"));

    assertThrows(UnsupportedOperationException.class, () -> list.add("B"));
  }
}
