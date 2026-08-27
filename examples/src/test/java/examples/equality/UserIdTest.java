package examples.equality;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class UserIdTest {
  @Test
  void equalsで等しい値は同じhashCodeを返す() {
    var first = new UserId("u-42");
    var second = new UserId("u-42");

    assertEquals(first, second);
    assertEquals(first.hashCode(), second.hashCode());
  }

  @Test
  void equalsとhashCodeを実装した値はHashSetで検索できる() {
    var users = new HashSet<UserId>();
    users.add(new UserId("u-42"));

    assertTrue(users.contains(new UserId("u-42")));
  }
}
