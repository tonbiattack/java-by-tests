package examples.map;

import java.util.Map;

public final class VisitCounts {
  private VisitCounts() {}

  public static int countFor(Map<String, Integer> counts, String page) {
    return counts.computeIfAbsent(page, ignored -> 0);
  }
}
