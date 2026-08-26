package examples.string;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class StringComparisonTest {@Test void 同じ内容でも別のStringなら参照は等しくない(){var literal="java";var copied=new String("java");assertFalse(StringComparison.sameReference(literal,copied));}@Test void 同じ内容のStringはequalsで等しい(){var literal="java";var copied=new String("java");assertTrue(StringComparison.sameValue(literal,copied));}}
