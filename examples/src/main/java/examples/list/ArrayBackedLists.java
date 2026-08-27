package examples.list;

import java.util.Arrays;
import java.util.List;

public final class ArrayBackedLists {
  private ArrayBackedLists() {}

  public static List<String> from(String[] values) {
    return Arrays.asList(values);
  }
}
