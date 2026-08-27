package examples.string;

public final class UnicodeLengths {
  private UnicodeLengths() {}

  public static int utf16Length(String value) {
    return value.length();
  }

  public static int codePointLength(String value) {
    return value.codePointCount(0, value.length());
  }
}
