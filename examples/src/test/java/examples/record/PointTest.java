package examples.record;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PointTest {
  @Test
  void 同じ値を持つrecordはequalsで等しくなる() {
    var first = new Point(10, 20);
    var second = new Point(10, 20);
    assertEquals(first, second);
  }

  @Test
  void 同じ値を持つrecordは同じhashCodeを持つ() {
    var first = new Point(10, 20);
    var second = new Point(10, 20);
    assertEquals(first.hashCode(), second.hashCode());
  }
}
