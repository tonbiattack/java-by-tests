package examples.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class StringBuildersTest {
  @Test
  void StringBuilderのappendは元のインスタンスを変更する() {
    var builder = new StringBuilder("Java");

    StringBuilders.appendLabel(builder, " 21");

    assertEquals("Java 21", builder.toString());
  }

  @Test
  void StringBuilderのappendは同じインスタンスを返す() {
    var builder = new StringBuilder();

    assertSame(builder, StringBuilders.appendLabel(builder, "Java"));
  }
}
