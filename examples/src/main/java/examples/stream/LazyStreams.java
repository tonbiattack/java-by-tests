package examples.stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class LazyStreams {
  private LazyStreams() {}

  public static Stream<Integer> doubled(List<Integer> values, AtomicInteger mapCalls) {
    return values.stream()
        .map(
            value -> {
              mapCalls.incrementAndGet();
              return value * 2;
            });
  }
}
