package examples.collector;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public final class DuplicateKeys {
  private DuplicateKeys() {}

  public static Map<String, Integer> withoutMerge(List<String> values) {
    return values.stream().collect(Collectors.toMap(String::toLowerCase, String::length));
  }

  public static Map<String, Integer> keepingLast(List<String> values) {
    return values.stream()
        .collect(Collectors.toMap(String::toLowerCase, String::length, BinaryOperator.maxBy(Integer::compare)));
  }
}
