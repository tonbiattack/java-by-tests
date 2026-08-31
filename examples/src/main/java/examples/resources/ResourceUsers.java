package examples.resources;

import java.util.List;

public final class ResourceUsers {
  private ResourceUsers() {}

  public static void useAndClose(List<String> events) {
    try (var resource = new TrackedResource(events)) {
      resource.use();
    }
  }

  public static void useTwoAndCloseInReverseOrder(List<String> events) {
    try (var first = new TrackedResource(events, "first");
        var second = new TrackedResource(events, "second")) {
      first.use();
      second.use();
    }
  }
}
