package examples.sortedset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public final class ComparatorEquivalence {
  private ComparatorEquivalence() {}

  public static Set<String> uniqueByLength(String... values) {
    var words = new TreeSet<String>(Comparator.comparingInt(String::length));
    for (var value : values) {
      words.add(value);
    }
    return words;
  }
}
