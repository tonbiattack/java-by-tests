package examples.generics;

import java.util.List;

public final class GenericBounds {
  private GenericBounds() {}

  public static double sum(List<? extends Number> values) {
    return values.stream().mapToDouble(Number::doubleValue).sum();
  }

  public static void addDefaults(List<? super Integer> target) {
    target.add(1);
    target.add(2);
  }
}
