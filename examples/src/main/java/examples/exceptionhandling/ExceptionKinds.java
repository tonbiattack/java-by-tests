package examples.exceptionhandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ExceptionKinds {
  private ExceptionKinds() {}

  public static String read(Path path) throws IOException {
    return Files.readString(path);
  }

  public static int requirePositive(int value) {
    if (value <= 0) {
      throw new IllegalArgumentException("value must be positive");
    }
    return value;
  }
}
