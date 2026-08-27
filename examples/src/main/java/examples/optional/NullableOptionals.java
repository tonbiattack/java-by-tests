package examples.optional;

import java.util.Optional;

public final class NullableOptionals {
  private NullableOptionals() {}

  public static Optional<String> fromNullable(String value) {
    return Optional.ofNullable(value);
  }

  public static Optional<String> fromRequired(String value) {
    return Optional.of(value);
  }
}
