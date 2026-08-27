package examples.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnicodeLengthsTest {
  @Test
  void 絵文字はUTF16のlengthでは2だがcodePointCountでは1になる() {
    String rocket = "🚀";

    assertEquals(2, UnicodeLengths.utf16Length(rocket));
    assertEquals(1, UnicodeLengths.codePointLength(rocket));
  }
}
