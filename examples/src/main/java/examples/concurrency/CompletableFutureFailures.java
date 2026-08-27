package examples.concurrency;

import java.util.concurrent.CompletableFuture;

public final class CompletableFutureFailures {
  private CompletableFutureFailures() {}

  public static String joinFailedFuture() {
    return CompletableFuture.<String>failedFuture(new IllegalArgumentException("invalid input"))
        .join();
  }
}
