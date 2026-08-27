package examples.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class NullableOptionalsTest {
  @Test
  void ofNullableはnullをemptyのOptionalへ変換する() {
    assertEquals(Optional.empty(), NullableOptionals.fromNullable(null));
  }

  @Test
  void ofはnullを受け取るとNullPointerExceptionを送出する() {
    assertThrows(NullPointerException.class, () -> NullableOptionals.fromRequired(null));
  }
}
