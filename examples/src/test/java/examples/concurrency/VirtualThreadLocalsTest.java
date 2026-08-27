package examples.concurrency;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class VirtualThreadLocalsTest {
  @Test
  void virtualThreadには親スレッドの通常のThreadLocal値が引き継がれない() throws InterruptedException {
    ThreadLocal<String> requestId = new ThreadLocal<>();
    requestId.set("req-42");

    assertNull(VirtualThreadLocals.valueSeenByVirtualThread(requestId));
  }
}
