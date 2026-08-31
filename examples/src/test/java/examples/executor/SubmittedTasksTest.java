package examples.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class SubmittedTasksTest {
  @Test
  void submitしたタスクの例外はFutureのgetでExecutionExceptionとして観測する() {
    try (var executor = Executors.newSingleThreadExecutor()) {
      var future = SubmittedTasks.submitFailing(executor);

      var exception = assertThrows(ExecutionException.class, future::get);

      assertEquals(IllegalArgumentException.class, exception.getCause().getClass());
    }
  }
}
