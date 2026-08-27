package examples.numbers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntegerIdentityTest {
  @Test
  void Integerはマイナス128から127まで同じ参照をキャッシュする() {
    assertTrue(IntegerIdentity.hasSameReference(127, 127));
  }

  @Test
  void Integerの128は参照比較では等しくない() {
    assertFalse(IntegerIdentity.hasSameReference(128, 128));
  }
}
