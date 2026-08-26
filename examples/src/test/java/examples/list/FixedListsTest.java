package examples.list;
import org.junit.jupiter.api.Test;import java.util.List;import static org.junit.jupiter.api.Assertions.assertEquals;import static org.junit.jupiter.api.Assertions.assertThrows;
class FixedListsTest {@Test void ListOfは指定した順序の要素を持つ(){assertEquals(List.of("green","blue"),FixedLists.colors());}@Test void ListOfが返すListには要素を追加できない(){var colors=FixedLists.colors();assertThrows(UnsupportedOperationException.class,()->colors.add("red"));}}
