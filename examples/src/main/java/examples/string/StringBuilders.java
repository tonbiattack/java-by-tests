package examples.string;

public final class StringBuilders {
  private StringBuilders() {}

  public static StringBuilder appendLabel(StringBuilder builder, String label) {
    return builder.append(label);
  }
}
