package examples.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringWhitespaceTest {
  @Test
  void 空文字列はisBlankでtrueになる() {
    assertTrue(StringWhitespace.hasOnlyWhitespace(""));
  }

  @Test
  void 空白だけのStringはisBlankでtrueになる() {
    assertTrue(StringWhitespace.hasOnlyWhitespace(" \n\t"));
  }

  @Test
  void 文字を含むStringはisBlankでfalseになる() {
    assertFalse(StringWhitespace.hasOnlyWhitespace(" java "));
  }
}
