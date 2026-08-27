package examples.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MutableMapKeysTest {
  @Test
  void HashMapへ登録した後にキーを変更すると同じキーで検索できない() {
    var key = new MutableMapKeys.Key("draft");
    var values = MutableMapKeys.mapWith(key);

    key.changeTo("published");

    assertFalse(values.containsKey(key));
    assertNull(values.get(key));
  }
}
