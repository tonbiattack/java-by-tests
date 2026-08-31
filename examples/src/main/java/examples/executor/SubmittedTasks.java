package examples.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class SubmittedTasks {
  private SubmittedTasks() {}

  public static Future<String> submitFailing(ExecutorService executor) {
    Callable<String> task = () -> { throw new IllegalArgumentException("invalid task"); };
    return executor.submit(task);
  }
}
