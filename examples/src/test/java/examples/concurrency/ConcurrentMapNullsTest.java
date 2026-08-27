package examples.concurrency;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ConcurrentMapNullsTest {
  @Test
  void ConcurrentHashMapはnullキーとnull値を許可しない() {
    assertThrows(NullPointerException.class, ConcurrentMapNulls::putNullKey);
    assertThrows(NullPointerException.class, ConcurrentMapNulls::putNullValue);
  }
}
