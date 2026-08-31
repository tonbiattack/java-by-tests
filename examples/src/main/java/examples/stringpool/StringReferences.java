package examples.stringpool;

public final class StringReferences {
  private StringReferences() {}

  public static boolean literalsShareReference() {
    String first = "java";
    String second = "java";
    return first == second;
  }

  public static boolean newStringSharesReference() {
    return "java" == new String("java");
  }

  public static boolean internedStringSharesReference() {
    return "java" == new String("java").intern();
  }
}
