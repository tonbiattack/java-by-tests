package examples.stream;

import java.util.stream.Stream;

public final class SingleUseStreams {
  private SingleUseStreams() {}

  public static long consumeThenCountAgain(Stream<String> values) {
    values.toList();
    return values.count();
  }
}
