package examples.stream;
import java.util.List;
public final class PositiveNumbers {private PositiveNumbers(){} public static List<Integer> onlyPositive(List<Integer> values){return values.stream().filter(value->value>0).toList();}}

