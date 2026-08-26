package examples.stream;
import org.junit.jupiter.api.Test;import java.util.ArrayList;import java.util.List;import static org.junit.jupiter.api.Assertions.assertEquals;
class PositiveNumbersTest {@Test void filterは正の数だけを残す(){assertEquals(List.of(3,8),PositiveNumbers.onlyPositive(List.of(-2,3,0,8)));}@Test void filterは入力のListを変更しない(){var values=new ArrayList<>(List.of(-2,3));PositiveNumbers.onlyPositive(values);assertEquals(List.of(-2,3),values);}}
