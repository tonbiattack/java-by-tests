package examples.stream;

import java.util.List;

public final class ImmutableStreamLists {
  private ImmutableStreamLists() {}

  public static List<String> copyOf(List<String> values) {
    return values.stream().toList();
  }
}
