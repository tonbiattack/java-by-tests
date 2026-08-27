package examples.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public final class VirtualThreadLocals {
  private VirtualThreadLocals() {}

  public static String valueSeenByVirtualThread(ThreadLocal<String> local)
      throws InterruptedException {
    AtomicReference<String> observed = new AtomicReference<>();
    Thread worker = Thread.ofVirtual().start(() -> observed.set(local.get()));
    worker.join();
    return observed.get();
  }
}
