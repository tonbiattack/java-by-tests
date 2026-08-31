package examples.resources;

import java.util.List;

public final class TrackedResource implements AutoCloseable {
  private final List<String> events;
  private final String name;

  public TrackedResource(List<String> events) {
    this(events, "resource");
  }

  public TrackedResource(List<String> events, String name) {
    this.events = events;
    this.name = name;
  }

  public void use() {
    events.add("used");
  }

  @Override
  public void close() {
    events.add("closed:" + name);
  }
}
