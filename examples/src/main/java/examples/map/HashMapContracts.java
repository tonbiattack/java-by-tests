package examples.map;

import java.util.HashMap;
import java.util.Map;

public final class HashMapContracts {
  private HashMapContracts() {}

  public static Map<CollisionKey, String> valuesWithCollidingHashes() {
    Map<CollisionKey, String> values = new HashMap<>();
    values.put(new CollisionKey("alpha"), "A");
    values.put(new CollisionKey("beta"), "B");
    return values;
  }

  public static Map<InconsistentKey, String> valuesWithInconsistentKey(InconsistentKey key) {
    Map<InconsistentKey, String> values = new HashMap<>();
    values.put(key, "stored");
    return values;
  }

  public record CollisionKey(String id) {
    @Override
    public int hashCode() {
      return 7;
    }
  }

  public record InconsistentKey(String id, int hash) {
    @Override
    public boolean equals(Object other) {
      return other instanceof InconsistentKey key && id.equals(key.id);
    }

    @Override
    public int hashCode() {
      return hash;
    }
  }
}
