package examples.optional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class OptionalFallbacks {
  private OptionalFallbacks() {}

  public static String withOrElse(Optional<String> value, AtomicInteger fallbackCalls) {
    return value.orElse(fallback(fallbackCalls));
  }

  public static String withOrElseGet(Optional<String> value, AtomicInteger fallbackCalls) {
    return value.orElseGet(() -> fallback(fallbackCalls));
  }

  private static String fallback(AtomicInteger fallbackCalls) {
    fallbackCalls.incrementAndGet();
    return "guest";
  }
}
