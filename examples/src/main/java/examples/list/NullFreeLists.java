package examples.list;

import java.util.List;

public final class NullFreeLists {
  private NullFreeLists() {}

  public static List<String> values(String first, String second) {
    return List.of(first, second);
  }
}
