package examples.interruption;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InterruptFlagsTest {
  @Test
  void ThreadInterruptedは現在の割り込み状態を返してclearする() {
    try {
      Thread.currentThread().interrupt();

      assertTrue(InterruptFlags.consumeCurrentThreadInterrupt());
      assertFalse(Thread.currentThread().isInterrupted());
    } finally {
      Thread.interrupted();
    }
  }
}
