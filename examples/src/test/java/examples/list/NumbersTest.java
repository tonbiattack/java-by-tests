package examples.list;
import org.junit.jupiter.api.Test;import java.util.ArrayList;import java.util.List;import static org.junit.jupiter.api.Assertions.assertEquals;import static org.junit.jupiter.api.Assertions.assertSame;
class NumbersTest {@Test void addすると元のListに要素が追加される(){var list=new ArrayList<Integer>();var returned=Numbers.add(list,10);assertEquals(List.of(10),list);assertSame(list,returned);}}
