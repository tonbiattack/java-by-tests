package examples.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OptionalApiDesignTest {
  @Test
  void Optional型の引数にもnullを渡せるため不在表現が二重になる() {
    assertThrows(
        NullPointerException.class, () -> OptionalApiDesign.displayFromOptionalArgument(null));
    assertEquals("guest", OptionalApiDesign.displayFromNullableArgument(null));
  }

  @Test
  void Optional型のフィールドにもnullを渡せるため利用時に失敗する() {
    var profile = new OptionalApiDesign.Profile(null);

    assertThrows(NullPointerException.class, profile::displayName);
  }
}
