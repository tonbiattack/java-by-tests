package examples.stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SingleUseStreamsTest {
  @Test
  void 終端操作を実行したStreamは再利用できない() {
    assertThrows(
        IllegalStateException.class,
        () -> SingleUseStreams.consumeThenCountAgain(Stream.of("java", "junit")));
  }
}
