package examples.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.CompletionException;
import org.junit.jupiter.api.Test;

class CompletableFutureFailuresTest {
  @Test
  void joinは非同期処理の失敗をCompletionExceptionで包む() {
    CompletionException exception =
        assertThrows(CompletionException.class, CompletableFutureFailures::joinFailedFuture);

    assertInstanceOf(IllegalArgumentException.class, exception.getCause());
    assertEquals("invalid input", exception.getCause().getMessage());
  }
}
