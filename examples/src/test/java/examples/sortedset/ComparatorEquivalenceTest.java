package examples.sortedset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComparatorEquivalenceTest {
  @Test
  void comparatorが0を返す異なる値はTreeSetで同じ要素として扱われる() {
    var words = ComparatorEquivalence.uniqueByLength("cat", "dog", "java");

    assertEquals(List.of("cat", "java"), List.copyOf(words));
    assertEquals(2, words.size());
  }

  @Test
  void comparatorが0を返す値は登録していなくてもcontainsで見つかる() {
    var words = ComparatorEquivalence.uniqueByLength("cat");

    assertTrue(words.contains("dog"));
  }
}
