package examples.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResourceUsersTest {
  @Test
  void tryWithResourcesは処理後にcloseを必ず呼ぶ() {
    var events = new ArrayList<String>();

    ResourceUsers.useAndClose(events);

    assertEquals(List.of("used", "closed:resource"), events);
  }

  @Test
  void tryWithResourcesは複数のresourceを宣言と逆順にcloseする() {
    var events = new ArrayList<String>();

    ResourceUsers.useTwoAndCloseInReverseOrder(events);

    assertEquals(List.of("used", "used", "closed:second", "closed:first"), events);
  }
}
