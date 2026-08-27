package examples.record;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ArrayRecordsTest {
  @Test
  void 同じ要素の別配列を持つrecordはequalsで等しくならない() {
    var first = new ArrayRecords.Bytes(new byte[] {1, 2});
    var second = new ArrayRecords.Bytes(new byte[] {1, 2});

    assertNotEquals(first, second);
    assertArrayEquals(first.value(), second.value());
  }
}
