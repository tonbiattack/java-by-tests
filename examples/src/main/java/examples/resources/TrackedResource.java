package examples.resources;

import java.util.List;

public final class TrackedResource implements AutoCloseable {
  private final List<String> events;

  public TrackedResource(List<String> events) {
    this.events = events;
  }

  public void use() {
    events.add("used");
  }

  @Override
  public void close() {
    events.add("closed");
  }
}
