package examples.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class UnicodeNormalizationTest {
  @Test
  void 見た目が同じでも合成済みと結合文字の文字列はequalsで異なる() {
    String composed = "é";
    String decomposed = "e\u0301";

    assertNotEquals(composed, decomposed);
    assertEquals(UnicodeNormalization.nfc(composed), UnicodeNormalization.nfc(decomposed));
  }
}
