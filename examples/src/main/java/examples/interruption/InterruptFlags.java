package examples.interruption;

public final class InterruptFlags {
  private InterruptFlags() {}

  public static boolean consumeCurrentThreadInterrupt() {
    return Thread.interrupted();
  }
}
