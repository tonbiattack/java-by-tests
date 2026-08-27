package examples.exceptionhandling;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class ExceptionKindsTest {
  @Test
  void 存在しないファイルの読み込みはcheckedのIOExceptionを送出する() {
    assertThrows(IOException.class, () -> ExceptionKinds.read(Path.of("missing-file.txt")));
  }

  @Test
  void 不正な引数はuncheckedのIllegalArgumentExceptionを送出する() {
    assertThrows(IllegalArgumentException.class, () -> ExceptionKinds.requirePositive(0));
  }
}
