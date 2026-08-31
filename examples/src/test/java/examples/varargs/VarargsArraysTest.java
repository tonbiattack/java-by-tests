package examples.varargs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class VarargsArraysTest {
  @Test
  void 配列を渡すvarargsは配列をコピーせず同じ配列を受け取る() {
    var values = new String[] {"before", "second"};

    VarargsArrays.replaceFirst("after", values);

    assertArrayEquals(new String[] {"after", "second"}, values);
  }
}
