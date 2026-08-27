package examples.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MutableMapKeys {
  private MutableMapKeys() {}

  public static Map<Key, String> mapWith(Key key) {
    Map<Key, String> values = new HashMap<>();
    values.put(key, "stored");
    return values;
  }

  public static final class Key {
    private String value;

    public Key(String value) {
      this.value = value;
    }

    public void changeTo(String value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof Key key && value.equals(key.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }
  }
}
