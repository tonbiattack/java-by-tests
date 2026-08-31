package examples.initialization;

import java.util.ArrayList;
import java.util.List;

public final class StaticOrder {
  private static final List<String> EVENTS = new ArrayList<>();
  private static final String FIRST = record("first");
  private static final String SECOND = record("second");

  private StaticOrder() {}

  private static String record(String event) {
    EVENTS.add(event);
    return event;
  }

  public static List<String> events() {
    return List.copyOf(EVENTS);
  }

  public static String second() {
    return SECOND;
  }
}
