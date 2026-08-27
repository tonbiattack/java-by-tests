package examples.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class LazyStreamsTest {
  @Test
  void Streamは終端操作までmapを評価しない() {
    var mapCalls = new AtomicInteger();
    var stream = LazyStreams.doubled(List.of(1, 2), mapCalls);

    assertEquals(0, mapCalls.get());
    assertEquals(List.of(2, 4), stream.toList());
    assertEquals(2, mapCalls.get());
  }
}
