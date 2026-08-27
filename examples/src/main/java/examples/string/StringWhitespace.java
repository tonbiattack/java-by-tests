package examples.string;

public final class StringWhitespace {
  private StringWhitespace() {}

  public static boolean hasOnlyWhitespace(String value) {
    return value.isBlank();
  }
}
