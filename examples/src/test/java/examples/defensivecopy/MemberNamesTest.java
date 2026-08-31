package examples.defensivecopy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberNamesTest {
  @Test
  void constructorは入力Listをコピーして後からの変更を受けない() {
    var input = new ArrayList<>(List.of("Ada"));
    var names = new MemberNames(input);

    input.add("Linus");

    assertEquals(List.of("Ada"), names.values());
  }

  @Test
  void 公開するListも変更できない() {
    var names = new MemberNames(List.of("Ada"));

    assertThrows(UnsupportedOperationException.class, () -> names.values().add("Linus"));
  }
}
