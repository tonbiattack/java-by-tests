package examples.synchronization;

public final class ReentrantMonitors {
  private int calls;

  public synchronized int outer() {
    return inner();
  }

  private synchronized int inner() {
    return ++calls;
  }
}
