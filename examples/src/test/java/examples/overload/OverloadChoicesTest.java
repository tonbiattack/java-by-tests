package examples.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OverloadChoicesTest {
  @Test
  void primitiveのshortはboxingよりwideningを優先してlongを選ぶ() {
    short value = 1;

    assertEquals("long", OverloadChoices.select(value));
  }

  @Test
  void Integer参照はIntegerのoverloadを選ぶ() {
    assertEquals("Integer", OverloadChoices.select(Integer.valueOf(1)));
  }
}
