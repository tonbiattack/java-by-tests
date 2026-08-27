package examples.optional;

import java.util.Optional;

public final class OptionalMapping {
  private OptionalMapping() {}

  public static Optional<Optional<String>> withMap(Optional<String> value) {
    return value.map(Optional::of);
  }

  public static Optional<String> withFlatMap(Optional<String> value) {
    return value.flatMap(Optional::of);
  }
}
