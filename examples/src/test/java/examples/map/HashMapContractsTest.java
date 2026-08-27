package examples.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class HashMapContractsTest {
  @Test
  void 同じhashCodeでもequalsが異なるキーは別の値として保存できる() {
    var values = HashMapContracts.valuesWithCollidingHashes();

    assertEquals(2, values.size());
    assertEquals("A", values.get(new HashMapContracts.CollisionKey("alpha")));
    assertEquals("B", values.get(new HashMapContracts.CollisionKey("beta")));
  }

  @Test
  void equalsがtrueでもhashCodeが違うキーでは登録済みの値を検索できない() {
    var values =
        HashMapContracts.valuesWithInconsistentKey(new HashMapContracts.InconsistentKey("same", 1));

    assertFalse(values.containsKey(new HashMapContracts.InconsistentKey("same", 2)));
  }
}
