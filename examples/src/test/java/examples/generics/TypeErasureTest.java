package examples.generics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TypeErasureTest {
  @Test
  void 異なる型引数のArrayListは実行時には同じクラスである() {
    assertTrue(TypeErasure.listsWithDifferentTypeArgumentsShareRuntimeClass());
  }
}
