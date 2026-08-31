package examples.overload;

public final class OverloadChoices {
  private OverloadChoices() {}

  public static String select(long value) {
    return "long";
  }

  public static String select(Integer value) {
    return "Integer";
  }
}
