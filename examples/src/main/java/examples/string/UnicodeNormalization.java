package examples.string;

import java.text.Normalizer;

public final class UnicodeNormalization {
  private UnicodeNormalization() {}

  public static String nfc(String value) {
    return Normalizer.normalize(value, Normalizer.Form.NFC);
  }
}
