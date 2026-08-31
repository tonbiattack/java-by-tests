package examples.collectionviews;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListSnapshotsTest {
  @Test
  void unmodifiableViewは元のListの後続変更を反映する() {
    var source = new ArrayList<>(List.of("A"));
    var view = ListSnapshots.unmodifiableView(source);

    source.add("B");

    assertEquals(List.of("A", "B"), view);
    assertThrows(UnsupportedOperationException.class, () -> view.add("C"));
  }

  @Test
  void immutableCopyは元のListの後続変更を反映しない() {
    var source = new ArrayList<>(List.of("A"));
    var copy = ListSnapshots.immutableCopy(source);

    source.add("B");

    assertEquals(List.of("A"), copy);
  }
}
