package examples.list;

import java.util.List;

public final class FixedLists {
  private FixedLists() {}

  public static List<String> colors() {
    return List.of("green", "blue");
  }
}
