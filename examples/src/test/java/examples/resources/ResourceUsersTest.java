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

    assertEquals(List.of("used", "closed"), events);
  }
}
