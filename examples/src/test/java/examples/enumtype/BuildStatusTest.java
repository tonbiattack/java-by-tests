package examples.enumtype;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BuildStatusTest {
  @Test
  void valueOfで得たenum定数は宣言済み定数と同じインスタンスである() {
    assertSame(BuildStatus.READY, BuildStatus.valueOf("READY"));
    assertTrue(BuildStatus.READY == BuildStatus.valueOf("READY"));
  }
}
