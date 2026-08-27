package examples.map;

import java.util.HashMap;
import java.util.Map;

public final class NullValues {
  private NullValues() {}

  public static Map<String, String> withNullValue() {
    Map<String, String> values = new HashMap<>();
    values.put("configured", null);
    return values;
  }
}
