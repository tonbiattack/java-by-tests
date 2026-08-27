package examples.numbers;

public final class IntegerIdentity {
  private IntegerIdentity() {}

  public static boolean hasSameReference(int left, int right) {
    return Integer.valueOf(left) == Integer.valueOf(right);
  }
}
