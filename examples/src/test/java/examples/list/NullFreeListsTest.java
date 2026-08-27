package examples.list;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NullFreeListsTest {
  @Test
  void ListOfはnull要素を持つListを作れない() {
    assertThrows(NullPointerException.class, () -> NullFreeLists.values("java", null));
  }
}
