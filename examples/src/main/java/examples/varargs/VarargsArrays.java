package examples.varargs;

public final class VarargsArrays {
  private VarargsArrays() {}

  public static void replaceFirst(String replacement, String... values) {
    values[0] = replacement;
  }
}
