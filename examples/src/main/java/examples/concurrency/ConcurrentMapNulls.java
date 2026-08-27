package examples.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public final class ConcurrentMapNulls {
  private ConcurrentMapNulls() {}

  public static void putNullKey() {
    new ConcurrentHashMap<String, String>().put(null, "value");
  }

  public static void putNullValue() {
    new ConcurrentHashMap<String, String>().put("key", null);
  }
}
