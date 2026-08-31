package examples.collectionviews;

import java.util.Collections;
import java.util.List;

public final class ListSnapshots {
  private ListSnapshots() {}

  public static List<String> unmodifiableView(List<String> values) {
    return Collections.unmodifiableList(values);
  }

  public static List<String> immutableCopy(List<String> values) {
    return List.copyOf(values);
  }
}
