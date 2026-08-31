package examples.synchronization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReentrantMonitorsTest {
  @Test
  void 同じスレッドは保持中のsynchronizedモニタを再入できる() {
    var monitor = new ReentrantMonitors();

    assertEquals(1, monitor.outer());
    assertEquals(2, monitor.outer());
  }
}
