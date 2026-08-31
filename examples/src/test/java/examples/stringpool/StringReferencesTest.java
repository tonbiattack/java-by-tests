package examples.stringpool;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringReferencesTest {
  @Test
  void 同じリテラルはpoolの同じ参照を共有する() {
    assertTrue(StringReferences.literalsShareReference());
  }

  @Test
  void newStringは同じ内容でも別の参照を作る() {
    assertFalse(StringReferences.newStringSharesReference());
  }

  @Test
  void internはpool内の参照を返す() {
    assertTrue(StringReferences.internedStringSharesReference());
  }
}
